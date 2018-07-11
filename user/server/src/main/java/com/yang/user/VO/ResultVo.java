package com.yang.user.VO;

import lombok.Data;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 14:18
 * @Description: http 请求返回的最外层对象
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
