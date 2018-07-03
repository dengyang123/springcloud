package com.yang.order.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:03
 * @Description:
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private  Integer code;
    private  String  message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
