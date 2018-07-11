package com.yang.user.controller;

import com.yang.user.VO.ResultVo;
import com.yang.user.constant.CookieConstant;
import com.yang.user.constant.RedisConstant;
import com.yang.user.dataobject.UserInfo;
import com.yang.user.enums.ResultEnum;
import com.yang.user.enums.RoleEnum;
import com.yang.user.service.UserService;
import com.yang.user.utils.CookieUtil;
import com.yang.user.utils.ResultVoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 14:18
 * @Description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
   @GetMapping("buyer")
    public ResultVo buyer(@RequestParam("openid")String openid, HttpServletResponse response){
        //1.openid 和数据库里的数据匹配
       UserInfo userInfo = userService.findByOpenid(openid);
       if (userInfo==null){
           return ResultVoUtil.error(ResultEnum.LOGIN_FAIL);
       }
       //2.判断角色
        if (RoleEnum.BUYER.getCode()!=userInfo.getRole()){
           return ResultVoUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.cookie里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        return  ResultVoUtil.success();
    }


    /**
     * 卖家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("seller")
    public ResultVo seller(@RequestParam("openid")String openid, HttpServletRequest request, HttpServletResponse response){

        //判断是否已登录
        Cookie  cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie!=null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
          return  ResultVoUtil.success();
        }
        //1.openid 和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo==null){
            return ResultVoUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if (RoleEnum.SELLER.getCode()!=userInfo.getRole()){
            return ResultVoUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.redis设置key=UUID,value=xyz
        String token=UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid,
                expire,
                TimeUnit.SECONDS);
        //4.cookie里设置token=uuid
        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);
        return  ResultVoUtil.success();
    }


}
