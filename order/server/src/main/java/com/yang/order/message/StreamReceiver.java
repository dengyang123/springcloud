package com.yang.order.message;

import com.yang.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yang
 * @Date: 2018\7\4 0004 14:47
 * @Description:
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    //@StreamListener(StreamClient.INPUT)
    //public  void process(Object message){
      //  log.info("StreamReceiver :{}",message);
    //}

    /**
     * 接收OrderDTO对象消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    public  void process(OrderDTO message){
      log.info("StreamReceiver :{}",message);
      //发送mq消息
    }







}
