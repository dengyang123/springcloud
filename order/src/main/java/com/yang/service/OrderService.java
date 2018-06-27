package com.yang.service;

import com.yang.dataobject.OrderDetail;
import com.yang.dataobject.OrderMaster;
import com.yang.dto.OrderDTO;

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

}
