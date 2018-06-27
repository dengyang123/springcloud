package com.yang.repository;


import com.yang.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 16:49
 * @Description:
 */
public interface OderDetailRespository extends JpaRepository<OrderDetail,String> {
}
