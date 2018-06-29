package com.yang.controller;

import com.yang.client.ProductClient;
import com.yang.dataobject.ProductInfo;
import com.yang.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 13:48
 * @Description:
 */
@RestController
@Slf4j
public class ClientController {

      @Autowired
      private ProductClient productClient;

      @GetMapping("/getProductMsg")
      public String getProductMsg(){
         String response= productClient.prductMsg();
         log.info("response={}" ,response);
         return response;
      }

      @GetMapping("/getProductList")
      public  String getProductList(){
          List<ProductInfo> list = productClient.listForOrder(Arrays.asList("164103465734242707"));
          log.info("list={}",list);
          return "OK";
      }
      @GetMapping("/productDecreaseStock")
      public String decreaseStock(){
          productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022",2)));
          return "ok";
    }



}
