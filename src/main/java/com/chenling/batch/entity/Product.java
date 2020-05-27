package com.chenling.batch.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * @author chenling
 * @date 2020/5/27  11:46
 * @since V1.0.0
 */
@Data
@Document("product")
@TableName("product")
public class Product {


    @MongoId
    @TableId
    private Long id;

    @Field("name")
    private String name;

    @Field("size")
    private String size;

    @Field("address")
    private String address;

    @Field("manufactureDate")
    private Date manufactureDate;

    @Field("price")
    private  Integer price;

}
