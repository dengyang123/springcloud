package com.yang.repository;

import com.yang.OrderApplicationTests;
import com.yang.dataobject.OrderMaster;
import com.yang.enums.OrderStatusEnum;
import com.yang.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:11
 * @Description:
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public  void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("阳阳阳阳啊");
        orderMaster.setBuyerPhone("13761092459");
        orderMaster.setBuyerAddress("东方纯一大厦");
        orderMaster.setBuyerOpenid("110120119");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result!=null);
    }

}