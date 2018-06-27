package com.yang.service.impl;

import com.yang.dataobject.OrderDetail;
import com.yang.dataobject.OrderMaster;
import com.yang.dto.OrderDTO;
import com.yang.enums.OrderStatusEnum;
import com.yang.enums.PayStatusEnum;
import com.yang.repository.OderDetailRespository;
import com.yang.repository.OrderMasterRepository;
import com.yang.service.OrderService;
import com.yang.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:40
 * @Description:
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OderDetailRespository oderDetailRespository;



    @Override
    public OrderDTO create(OrderDTO orderDTO) {


          //TODO  查询商品信息（调用商品服务）
          //TODO 计算总价
          //TODO  扣库存（调用商品服务）
          //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        return orderDTO;
    }
}
