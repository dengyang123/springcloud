package com.yang.order.exception;

import com.yang.order.enums.ResultEnum;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 10:07
 * @Description:
 */
public class OrderException extends  RuntimeException {

    private Integer code;

    public OrderException(Integer code ,String message){
        super(message);
        this.code=code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }



}
