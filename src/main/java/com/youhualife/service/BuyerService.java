package com.youhualife.service;

import com.youhualife.DTO.OrderDTO;

/**
 * created by guo19
 * created on 2018/1/29
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
