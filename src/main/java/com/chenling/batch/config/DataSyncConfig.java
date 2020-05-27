package com.chenling.batch.config;

import com.chenling.batch.entity.Product;
import com.chenling.batch.listener.WirterListener;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenling
 * @date 2020/5/27  11:58
 * @since V1.0.0
 */
@Component
@Slf4j
public class DataSyncConfig {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private WirterListener wirterListener;



    public Step dataSyncStep(){
        TaskletStep dataSyncStep = stepBuilderFactory
                .get("dataSyncStep")
                .<Product,Product>chunk(20000)
                .reader(mongoItemReader())
                .processor(itemProcessor())
                .writer(productMyBatisBatchItemWriter()).listener(wirterListener)
                .build();
        return dataSyncStep;
    }

    public MongoItemReader<Product> mongoItemReader () {
        log.info("--------------执行读取数据---------------");
        Map<String, Sort.Direction> sortOptions = new HashMap<>();
        sortOptions.put("id", Sort.Direction.DESC);
        Query query = new Query(Criteria.where("name").is("老干妈"));
        query.limit(10000);
        return new MongoItemReaderBuilder<Product>()
                .name("productItemReader")
//                .collection("product_in")
                .targetType(Product.class)
                .template(mongoTemplate)
//                .jsonQuery("{}")
                .query(query)
                .sorts(sortOptions)
                .build();
    }

    public MyBatisBatchItemWriter<Product> productMyBatisBatchItemWriter (){
        log.info("--------------执行写入数据---------------");
        return new MyBatisBatchItemWriterBuilder<Product>()
                .sqlSessionTemplate(new SqlSessionTemplate(sqlSessionFactory,ExecutorType.BATCH))
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("com.chenling.batch.mapper.ProductMapper.insert")
                .build();
    }

    public ItemProcessor<Product, Product> itemProcessor() {
        return item -> {
            item.setAddress("中国-广州");
            item.setManufactureDate(new Date());
            log.info("processing item = {}" , item);
            return item;
        };
    }



    @Bean
    public Job dataSyncJob() {
        return this.jobBuilderFactory.get("dataSyncJob")
                .start(dataSyncStep())
                .build();
    }


}
