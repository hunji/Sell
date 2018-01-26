package com.youhualife.service;

import com.youhualife.DTO.CartDTO;
import com.youhualife.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * created by guo19
 * created on 2018/1/24
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    Page<ProductInfo> findAll(Pageable pageable);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
