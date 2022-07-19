package com.lwx.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/5-16:02
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    //当mp实现添加操作的时候，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("balance", 0.0, metaObject);
        this.setFieldValByName("borrowPoint", 10.0, metaObject);
        this.setFieldValByName("shelfTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("donateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("lendTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("orderTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("purchaseTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("registerTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("rechargeTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("putTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    //当mp实现修改操作的时候，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
