package com.yang.order.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 16:56
 * @Description:
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
