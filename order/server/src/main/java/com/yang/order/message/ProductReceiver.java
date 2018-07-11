package com.yang.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yang.order.utils.JsonUtil;
import com.yang.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\7\6 0006 15:16
 * @Description:
 */
@Component
@Slf4j
public class ProductReceiver {

    private  static  final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        //message =>ProductInfoOutput
        log.info("Message信息{}",message);
        List<ProductInfoOutput> productInfoOutputList =(List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>(){});
        log.info("productInfoOutput信息{}",productInfoOutputList);

        //存储到redis中
        for (ProductInfoOutput productInfoOutput :productInfoOutputList){
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),String.valueOf(productInfoOutput.getProductStock()));
        }
    }

}
