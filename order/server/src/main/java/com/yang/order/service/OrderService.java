package com.yang.order.service;

import com.yang.order.dto.OrderDTO;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:36
 * @Description:
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO  create(OrderDTO orderDTO);

    /**
     * 完结订单（只能卖家操作）
     * @param orderId
     * @return
     */
    OrderDTO  finish(String orderId);

}
