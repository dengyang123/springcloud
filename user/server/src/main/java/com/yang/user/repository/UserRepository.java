package com.yang.user.repository;

import com.yang.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: yang
 * @Date: 2018\7\9 0009 14:10
 * @Description:
 */
public interface UserRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);

}
