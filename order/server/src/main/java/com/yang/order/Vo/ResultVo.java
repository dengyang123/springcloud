package com.yang.order.Vo;

import lombok.Data;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 10:56
 * @Description:
 */
@Data
public class ResultVo <T>{

    private  Integer code;

    private  String msg;

    private T data;



}
