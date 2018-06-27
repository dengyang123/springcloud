package com.yang.service;

import com.yang.ProductApplicationTests;
import com.yang.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 14:09
 * @Description:
 */
@Component
public class CategoryServiceTest  extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    //@Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list =categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}