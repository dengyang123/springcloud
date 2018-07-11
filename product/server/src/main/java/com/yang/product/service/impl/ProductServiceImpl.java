package com.yang.product.service.impl;


import com.rabbitmq.tools.json.JSONUtil;
import com.yang.product.common.DecreaseStockInput;
import com.yang.product.common.ProductInfoOutput;
import com.yang.product.dataobject.ProductInfo;
import com.yang.product.enums.ProductStatusEnum;
import com.yang.product.enums.ResultEnum;
import com.yang.product.exception.ProductException;
import com.yang.product.repository.ProductInfoRepository;
import com.yang.product.service.ProductService;
import com.yang.product.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private AmqpTemplate amqpTemplate;


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
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {
        List<ProductInfo> productInfoList =decreaseStockProcess(cartDTOList);
        //发送mq消息
       List<ProductInfoOutput>  productInfoOutputList =  productInfoList.stream().map(e ->{
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e,productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());

        amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> cartDTOList) {
        List<ProductInfo> list = new ArrayList<>();
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
            list.add(productInfo);
          }
          return  list;
    }


}
