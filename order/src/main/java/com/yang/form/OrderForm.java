package com.yang.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 09:58
 * @Description:
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号码")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车不能为空
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
