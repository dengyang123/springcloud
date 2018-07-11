package com.yang.user.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 14:32
 * @Description:
 */
@Getter
public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家"),;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;





}
