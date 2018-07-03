package com.yang.product.repository;

import com.yang.product.common.ProductInfoOutput;
import com.yang.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 10:51
 * @Description:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

     List<ProductInfo>  findByProductStatus(Integer productStatus);

     List<ProductInfo>  findByProductIdIn(List<String> productIdList);
}
