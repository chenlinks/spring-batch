package com.chenling.batch.controller;

import com.chenling.batch.service.BacthRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenling
 * @date 2020/5/27  14:08
 * @since V1.0.0
 */
@RestController
@RequestMapping("/api/v1/test")
public class ProductController {


    @Autowired
    private BacthRunService bacthRunService;


    @GetMapping
    public void test(){
        try {
            bacthRunService.runJob();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
