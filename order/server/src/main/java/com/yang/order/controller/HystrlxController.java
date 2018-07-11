package com.yang.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Auther: yang
 * @Date: 2018\7\10 0010 10:30
 * @Description:
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrlxController {



    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public  String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForObject("http://localhost:9080/product/listForOrder",Arrays.asList("157875227953464068"),String.class);
    }

    public String fallback(){
        return "太拥挤了，请稍后再试";
    }

    public String defaultFallback(){
        return "默认提示：太拥挤了，请稍后再试";
    }

}
