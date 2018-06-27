package com.yang.service.impl;

import com.yang.dataobject.ProductInfo;
import com.yang.enums.ProductStatusEnum;
import com.yang.repository.ProductInfoRepository;
import com.yang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:30
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
