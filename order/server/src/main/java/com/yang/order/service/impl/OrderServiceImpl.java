package com.yang.order.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yang.order.enums.ResultEnum;
import com.yang.order.exception.OrderException;
import com.yang.product.client.ProductClient;
import com.yang.product.common.DecreaseStockInput;
import com.yang.product.common.ProductInfoOutput;
import com.yang.order.dataobject.OrderDetail;
import com.yang.order.dataobject.OrderMaster;
import com.yang.order.dto.OrderDTO;
import com.yang.order.enums.OrderStatusEnum;
import com.yang.order.enums.PayStatusEnum;
import com.yang.order.repository.OderDetailRespository;
import com.yang.order.repository.OrderMasterRepository;
import com.yang.order.service.OrderService;
import com.yang.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.OpenOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:40
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OderDetailRespository oderDetailRespository;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        //TODO  查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput>   productInfoList = productClient.listForOrder(productIdList);
        //TODO 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for(ProductInfoOutput productInfo : productInfoList){
               if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价*数量
                   orderAmount= new BigDecimal(orderDetail.getProductQuantity()).multiply(productInfo.getProductPrice()).add(orderAmount);
                   BeanUtils.copyProperties(productInfo,orderDetail);
                   orderDetail.setOrderId(orderId);
                   orderDetail.setDetailId(KeyUtil.genUniqueKey());
                   orderDetail.setCreateTime(new Date());
                   orderDetail.setUpdateTime(new Date());
                   //订单详情入库
                   oderDetailRespository.save(orderDetail);
               }
            }
        }
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new DecreaseStockInput(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        //TODO  扣库存（调用商品服务）
        productClient.decreaseStock(cartDTOList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO finish(String orderId) {
        //1.先查询订单
        Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
        if (!orderMasterOptional.isPresent()){
            throw  new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.判断订单状态
        OrderMaster orderMaster = orderMasterOptional.get();
        if (OrderStatusEnum.NEW.getCode()!=orderMaster.getOrderStatus()){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //3.修改订单状态为完结
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);
        //查询订单详情
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDetail> orderDetails = oderDetailRespository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetails)){
            throw  new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }
}
