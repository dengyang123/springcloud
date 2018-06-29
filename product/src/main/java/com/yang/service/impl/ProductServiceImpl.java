package com.yang.service.impl;

import com.yang.dto.CartDTO;
import com.yang.dataobject.ProductInfo;
import com.yang.enums.ProductStatusEnum;
import com.yang.enums.ResultEnum;
import com.yang.exception.ProductException;
import com.yang.repository.ProductInfoRepository;
import com.yang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
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
