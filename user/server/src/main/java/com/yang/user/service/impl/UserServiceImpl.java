package com.yang.user.service.impl;

import com.yang.user.dataobject.UserInfo;
import com.yang.user.repository.UserRepository;
import com.yang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 14:15
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

    /**
     * 通过openid 查询用户信息
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return userRepository.findByOpenid(openid);
    }
}
