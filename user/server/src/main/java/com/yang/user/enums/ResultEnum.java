package com.yang.user.enums;

import lombok.Getter;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 10:10
 * @Description:
 */
@Getter
public enum ResultEnum {

    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"角色权限有误")




    ;


    private  Integer code;
    private  String  message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
