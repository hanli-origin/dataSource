package com.yhk.datasource.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.yhk.datasource.enums.DataSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DynamicDataSource
 * @Author ADMIN
 * @Date 2023/3/8
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {
    public static ThreadLocal<DataSources> dst = new ThreadLocal<>();

    @Autowired
    DruidDataSource dataSource1;
    @Autowired
    DruidDataSource dataSource2;
    @Override
    protected Object determineCurrentLookupKey() {
        return dst.get();
    }

    @Override
    public void afterPropertiesSet() {
        // targetDataSource init
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSources.INPUT,dataSource1);
        targetDataSource.put(DataSources.OUTPUT,dataSource2);
        super.setTargetDataSources(targetDataSource);
        // defaultDataSource init
        super.afterPropertiesSet();
    }
}
