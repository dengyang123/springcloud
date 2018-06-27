package com.yang.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 16:29
 * @Description: 订单明细
 */
@Data
@Entity
public class OrderDetail {

    @Id
    private String detailId;
    private String orderId;
    private String productId;
    //商品名称
    private String productName;
    //当前价格
    private BigDecimal productPrice;
    //数量
    private Integer productQuantity;
    //小图
    private String productIcon;
    private Date createTime;
    private Date updateTime;


}
