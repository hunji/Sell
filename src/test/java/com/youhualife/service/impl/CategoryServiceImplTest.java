package com.youhualife.service.impl;

import com.youhualife.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * created by guo19
 * created on 2018/1/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory model=categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),model.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11,12));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("男生专享", 10);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}