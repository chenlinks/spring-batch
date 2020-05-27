package com.chenling.batch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenling.batch.service.ProductService;
import com.chenling.batch.entity.Product;
import com.chenling.batch.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
 * @author chenling
 * @date 2020/5/27  14:01
 * @since V1.0.0
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {



}
