package com.order.orderservice.repository;

import com.order.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quan0
 * Date 6/6/2023 - 10:23 PM
 * Description: ...
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
