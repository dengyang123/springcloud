package com.yang.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 10:27
 * @Description:
 */
//@Table(name = "t_XXX")如果表名不一致时这样写
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;
    /**名字*/
    private String productName;
    /**单价*/
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态 0正常1下架
    private Integer productStatus;
    //类目
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;



}
