package com.yang.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 10:10
 * @Description:
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),



    ;


    private  Integer code;
    private  String  message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
