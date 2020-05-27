package com.chenling.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing(modular =true)
public class BatchStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchStudyApplication.class, args);
    }

}
