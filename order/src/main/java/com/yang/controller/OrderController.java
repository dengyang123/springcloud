package com.yang.controller;

import com.yang.Vo.ResultVo;
import com.yang.converter.OrderForm2OrderDTO;
import com.yang.dto.OrderDTO;
import com.yang.enums.ResultEnum;
import com.yang.exception.OrderException;
import com.yang.form.OrderForm;
import com.yang.service.OrderService;
import com.yang.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:33
 * @Description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
      if (bindingResult.hasErrors()){
          log.error("【创建订单】参数不正确，orderForm={}",orderForm);
          throw  new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
      }
       //orderForm ->orderDto
       OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
      if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
          log.error("【创建订单购物车信息为空】");
          throw  new OrderException(ResultEnum.CART_EMPTY);
      }
      OrderDTO result = orderService.create(orderDTO);
      Map<String,String> map = new HashMap<>();
      map.put("orderId",result.getOrderId());
      return ResultVoUtil.success(map);
    }


}
