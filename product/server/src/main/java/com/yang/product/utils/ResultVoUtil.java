package com.yang.product.utils;

import com.yang.product.VO.ResultVo;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 15:33
 * @Description:
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

}
