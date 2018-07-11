package com.yang.order.repository;


import com.yang.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 16:49
 * @Description:
 */
public interface OderDetailRespository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);

}
