package com.yang.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: yang
 * @Date: 2018\7\4 0004 14:45
 * @Description:
 */
public interface StreamClient {

    String INPUT="myMessage";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();



}
