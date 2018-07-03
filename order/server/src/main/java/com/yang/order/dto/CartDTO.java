package com.yang.order.dto;

import lombok.Data;

/**
 * @Auther: yang
 * @Date: 2018\6\29 0029 11:34
 * @Description:
 */
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO( ) {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
