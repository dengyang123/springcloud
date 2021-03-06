package com.yang.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: yang
 * @Date: 2018\7\4 0004 13:24
 * @Description: 发送mq消息测试
 */
@Component
public class MqSenderTest extends  OrderApplicationTests {


    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public  void send(){
         amqpTemplate.convertAndSend("myQueue","now" + new Date());
     }

    @Test
    public  void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer","now " + new Date());
    }





}
