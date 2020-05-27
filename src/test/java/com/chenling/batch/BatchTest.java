package com.chenling.batch;

import com.chenling.batch.service.BacthRunService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chenling
 * @date 2020/5/27  15:54
 * @since V1.0.0
 */
@SpringBootTest
public class BatchTest {


    @Autowired
    private BacthRunService bacthRunService;


    @Test
    public void test(){
        try {
            bacthRunService.runJob();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
