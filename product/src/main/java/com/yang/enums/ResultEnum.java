package com.yang.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\29 0029 13:55
 * @Description:
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(1,"库存不足"),

    ;

    private Integer code;
    private String  message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
