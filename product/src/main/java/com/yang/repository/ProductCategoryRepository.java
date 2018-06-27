package com.yang.repository;

import com.yang.dataobject.ProductCategory;
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
