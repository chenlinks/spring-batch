package com.chenling.batch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenling.batch.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenling
 * @date 2020/5/27  14:03
 * @since V1.0.0
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
