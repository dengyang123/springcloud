package com.yang.product.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:32
 * @Description: 商品上下架状态
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private  Integer code;
    private  String  message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
