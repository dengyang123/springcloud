package com.yang.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yang.dataobject.OrderDetail;
import com.yang.dto.OrderDTO;
import com.yang.enums.ResultEnum;
import com.yang.exception.OrderException;
import com.yang.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 10:30
 * @Description:
 */
@Slf4j
public class OrderForm2OrderDTO {

    public  static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【json装换】错误，String={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return  orderDTO;
    }


}
