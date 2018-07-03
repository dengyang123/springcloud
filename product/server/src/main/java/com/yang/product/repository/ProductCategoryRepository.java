package com.yang.product.repository;

import com.yang.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:09
 * @Description:
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer> {


    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
