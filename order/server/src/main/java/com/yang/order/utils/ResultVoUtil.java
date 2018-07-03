package com.yang.order.utils;

import com.yang.order.Vo.ResultVo;

/**
 * @Auther: yang
 * @Date: 2018\6\28 0028 11:00
 * @Description:
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return  resultVo;
    }


}
