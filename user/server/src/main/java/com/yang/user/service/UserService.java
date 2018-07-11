package com.yang.user.service;

import com.yang.user.dataobject.UserInfo;

/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 14:13
 * @Description:
 */
public interface UserService {

    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);


}
