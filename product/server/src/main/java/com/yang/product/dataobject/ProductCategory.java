package com.yang.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 11:05
 * @Description:
 */
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名字
    private String  categoryName;
    //类目编号
    private Integer  categoryType;

    private Date createTime;

    private Date updateTime;

}
