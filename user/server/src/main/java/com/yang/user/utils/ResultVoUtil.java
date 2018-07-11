package com.yang.user.utils;


import com.yang.user.VO.ResultVo;
import com.yang.user.enums.ResultEnum;

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

    public static ResultVo success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo error(ResultEnum resultEnum){
        ResultVo resultVo = new ResultVo();
         resultVo.setCode(resultEnum.getCode());
        resultVo.setMsg(resultEnum.getMessage());
        return resultVo;
    }




}
