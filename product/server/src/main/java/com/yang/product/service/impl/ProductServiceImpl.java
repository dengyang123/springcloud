package com.yang.product.service.impl;


import com.yang.product.common.DecreaseStockInput;
import com.yang.product.common.ProductInfoOutput;
import com.yang.product.dataobject.ProductInfo;
import com.yang.product.enums.ProductStatusEnum;
import com.yang.product.enums.ResultEnum;
import com.yang.product.exception.ProductException;
import com.yang.product.repository.ProductInfoRepository;
import com.yang.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {
        for (DecreaseStockInput cartDTO : cartDTOList){
          Optional<ProductInfo> productInfoOptional =productInfoRepository.findById(cartDTO.getProductId());
           //判断商品是否存在
           if(!productInfoOptional.isPresent()){
                throw  new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
           }
            ProductInfo productInfo = productInfoOptional.get();
           //判断库存是否充足
           Integer result =  productInfo.getProductStock()-cartDTO.getProductQuantity();
           if (result<0){
               throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
           }
           productInfo.setProductStock(result);
           productInfoRepository.save(productInfo);
        }

    }
}
