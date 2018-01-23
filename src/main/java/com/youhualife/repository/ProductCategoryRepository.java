package com.youhualife.repository;

import com.youhualife.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by guo19
 * created on 2018/1/22
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
