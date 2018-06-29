package com.yang.service;

import com.yang.dto.CartDTO;
import com.yang.ProductApplicationTests;
import com.yang.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:36
 * @Description:
 */
@Component
public class ProductServiceTest  extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findList(){
        List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public  void  decreaseStock() throws Exception{
        CartDTO cartDTO = new CartDTO("164103465734242707",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }


}