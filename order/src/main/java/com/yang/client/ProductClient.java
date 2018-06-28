package com.yang.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 15:21
 * @Description:
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String prductMsg();



}
