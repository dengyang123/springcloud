package com.yang.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 14:22
 * @Description:
 */
@Data
public class ProdcutVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVo> prodcutInfoVoList;

}
