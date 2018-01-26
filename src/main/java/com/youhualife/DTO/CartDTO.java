package com.youhualife.DTO;

import lombok.Data;

/**
 * 购物车
 * created by guo19
 * created on 2018/1/25
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
