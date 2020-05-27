package com.chenling.batch.service.impl;

import com.chenling.batch.service.MogoDBDataService;
import com.chenling.batch.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenling
 * @date 2020/5/27  11:52
 * @since V1.0.0
 */
@Repository
public class MogoDBDataServiceImpl implements MogoDBDataService {


    @Autowired
    private MongoTemplate mongoTemplate;



   public List<Product>  findProduct(){

       return null;
   }





}
