/*
package com.yang.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yang.apigateway.constant.RedisConstant;
import com.yang.apigateway.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.core.StringRedisTemplate;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

*/
/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 10:49
 * @Description: 权限拦截（区分买家和卖家）
 *//*

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        */
/**
         * /order/create 只能买家访问（cookie里有openid）
         * /order/finish 只能卖家访问 (cookie里有token 并且对应redis中的值)
         * /product/list 都可访问
         *//*

         if ("/order/order/create".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,"openid");
            if (cookie==null || StringUtils.isEmpty(cookie.getValue())){
               requestContext.setSendZuulResponse(false);
               requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
         }
         if ("/order/order/finish".equals(request.getRequestURI())){
             Cookie cookie = CookieUtil.get(request,"token");
             if (cookie == null
                   || StringUtils.isEmpty(cookie.getValue())
                   || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
           }

         }



        return null;
    }
}
*/
