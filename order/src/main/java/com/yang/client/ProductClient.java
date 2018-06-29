package com.yang.client;

import com.yang.dataobject.ProductInfo;
import com.yang.dto.CartDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 15:21
 * @Description:
 */
@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/msg")
    String prductMsg();

    //RequestBody  用了该注解请求必须为post
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> prodcutListId);


    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);


 }
