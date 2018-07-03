package com.yang.order.repository;

import com.yang.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 16:46
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
