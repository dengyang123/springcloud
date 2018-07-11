package com.yang.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yang
 * @Date: 2018\7\4 0004 11:24
 * @Description: 接收mq消息
 */
@Component
@Slf4j
public class MqReceiver {

    //1.@RabbitListener(queues="myQueue")
    //2.自动创建队列@RabbitListener(queuesToDeclare =@Queue("myQueue"))
    //3.自动创建Exchang和Queue绑定
    @RabbitListener(bindings =@QueueBinding(value    = @Queue("myQueue"),
                                            exchange = @Exchange("myExchange")))
    public  void  process(String message){
        log.info("MqReceiver :{}",message);
    }

    /**
     * 数码供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings=@QueueBinding(exchange = @Exchange("myOrder"),
            key = "computer",
            value= @Queue("computerOrder")
            ))
    public  void  processComputer(String message){
        log.info("computer   MqReceiver :{}",message);
    }


    /**
     * 水果供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings=@QueueBinding(exchange = @Exchange("myOrder"),
            key = "friut",
            value= @Queue("friutOrder")
    ))
    public  void  processFruit(String message){
        log.info("fruit    MqReceiver :{}",message);
    }

}
