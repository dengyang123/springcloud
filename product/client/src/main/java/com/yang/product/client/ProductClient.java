package com.yang.product.client;

import com.yang.product.common.DecreaseStockInput;
import com.yang.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 15:21
 * @Description:
 */
@FeignClient(name="product",fallback =ProductClient.ProductClientFallback.class )
public interface ProductClient {



    //RequestBody  用了该注解请求必须为post
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> prodcutListId);


    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);


    @Component
    static  class  ProductClientFallback implements ProductClient{

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> prodcutListId) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

        }
    }


 }
