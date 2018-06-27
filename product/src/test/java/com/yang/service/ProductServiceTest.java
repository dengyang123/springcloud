package com.yang.service;

import com.yang.ProductApplicationTests;
import com.yang.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:36
 * @Description:
 */
@Component
public class ProductServiceTest  extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    //@Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
}