package com.youhualife.service;

import com.youhualife.dataobject.ProductCategory;

import java.util.List;

/**
 * created by guo19
 * created on 2018/1/23
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
