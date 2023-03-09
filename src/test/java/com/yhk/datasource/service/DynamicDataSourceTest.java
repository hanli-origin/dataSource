package com.yhk.datasource.service;

import com.yhk.datasource.dao.Test1Dao;
import com.yhk.datasource.dao2.Test2Dao;
import com.yhk.datasource.entity.Test1;
import com.yhk.datasource.entity.Test2;
import com.yhk.datasource.enums.DataSources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName DynamicDataSourceTest
 * @Author ADMIN
 * @Date 2023/3/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext-dataSource.xml"})
public class DynamicDataSourceTest {

    @Autowired
    Test1Dao test1Dao;
    @Autowired
    Test2Dao test2Dao;
    @Test
    public void test01(){
        DynamicDataSource.dst.set(DataSources.INPUT);
        Test1 test1 = test1Dao.getById(2);
        System.out.println(test1);
    }
    @Test
    public void test02(){
        DynamicDataSource.dst.set(DataSources.OUTPUT);
        Test2 test2= test2Dao.getById(1);
        System.out.println(test2);
    }
}

