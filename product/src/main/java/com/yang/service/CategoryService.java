package com.yang.service;

import com.yang.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:42
 * @Description: 类目
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
