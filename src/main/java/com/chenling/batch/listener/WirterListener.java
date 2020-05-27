package com.chenling.batch.listener;

import com.chenling.batch.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenling
 * @date 2020/5/27  16:11
 * @since V1.0.0
 */
@Slf4j
@Component
public class WirterListener implements ItemWriteListener<Product> {


    @Override
    public void beforeWrite(List<? extends Product> list) {
        log.info("\n写之前的数据：{}",list);
    }

    @Override
    public void afterWrite(List<? extends Product> list) {
        log.info("\n写之后的数据：{}",list);
    }

    @Override
    public void onWriteError(Exception e, List<? extends Product> list) {
        log.error("\n写数据时错误：{}",list);
    }


}
