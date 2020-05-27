package com.chenling.batch.service.impl;

import com.chenling.batch.service.BacthRunService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenling
 * @date 2020/5/27  13:38
 * @since V1.0.0
 */
@Service
public class BacthRunServiceImpl implements BacthRunService {


    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRegistry jobRegistry;


    @Autowired
    private Job  dataSyncJob;


    @Override
    public void runJob() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(dataSyncJob,jobParameters);


    }
}
