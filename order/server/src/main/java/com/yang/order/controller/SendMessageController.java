package com.yang.order.controller;

import com.yang.order.dto.OrderDTO;
import com.yang.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: yang
 * @Date: 2018\7\4 0004 14:51
 * @Description:
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /**
     * 发送orderDto对象
     */
    @GetMapping("/sendMessage")
    public  void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }



}
