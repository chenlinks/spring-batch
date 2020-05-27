package com.chenling.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 批处理配置类
 * @author chenling
 * @date 2020/5/27  11:56
 * @since V1.0.0
 */
//@Configuration
//@EnableAutoConfiguration
//@EnableBatchProcessing(modular =true)
//public class SpringBatchConfiguration {
//
//
//    @Bean
//    public ApplicationContextFactory dataSyncJob(){
//        return new GenericApplicationContextFactory(DataSyncConfig.class);
//    }
//
//}
