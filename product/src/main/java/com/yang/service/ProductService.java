package com.yang.service;

import com.yang.dto.CartDTO;
import com.yang.dataobject.ProductInfo;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:27
 * @Description:
 */
public interface ProductService {

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo>  findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
