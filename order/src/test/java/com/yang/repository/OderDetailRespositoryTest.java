package com.yang.repository;

import com.yang.OrderApplicationTests;
import com.yang.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:21
 * @Description:
 */
@Component
public class OderDetailRespositoryTest  extends OrderApplicationTests {

    @Autowired
    private  OderDetailRespository oderDetailRespository;


    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123456");
        orderDetail.setDetailId("12367");
        orderDetail.setProductIcon("http://www.baidu.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.2));
        orderDetail.setProductQuantity(2);
        OrderDetail result =oderDetailRespository.save(orderDetail);
        Assert.assertTrue(result!=null);
    }
}