package com.youhualife.service.impl;

import com.youhualife.dataobject.ProductInfo;
import com.youhualife.enums.ProductStatusEnum;
import com.youhualife.repository.ProductInfoRepository;
import com.youhualife.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by guo19
 * created on 2018/1/24
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo onSale(String productId) {
        return null;
    }

    @Override
    public ProductInfo offSale(String productId) {
        return null;
    }
}
