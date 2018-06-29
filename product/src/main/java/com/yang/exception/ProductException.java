package com.yang.exception;

import com.yang.enums.ResultEnum;

/**
 * @Auther: yang
 * @Date: 2018\6\29 0029 13:53
 * @Description:
 */
public class ProductException extends  RuntimeException {

    private  Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public ProductException(ResultEnum resultEnum){
       super(resultEnum.getMessage());
       this.code=resultEnum.getCode();
    }
}
