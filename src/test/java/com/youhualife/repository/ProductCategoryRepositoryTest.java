package com.youhualife.repository;

import com.youhualife.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * created by guo19
 * created on 2018/1/23
 * productCategory的CRUD测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory= repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void addTest(){
        ProductCategory addModel=new ProductCategory();
        addModel.setCategoryName("测试添加类");
        addModel.setCategoryType(12);

        ProductCategory result= repository.save(addModel);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        ProductCategory updateModel=repository.findOne(2);
        updateModel.setCategoryName(updateModel.getCategoryName()+"6");

        repository.save(updateModel);

    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> categoryTypeList= Arrays.asList(11,12);
        List<ProductCategory> modelList=repository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotEquals(0,modelList.size());
    }
}