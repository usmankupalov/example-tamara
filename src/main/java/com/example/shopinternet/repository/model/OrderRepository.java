package com.example.shopinternet.repository.model;

import com.example.shopinternet.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderByOrderId(Integer orderId);
    Order findOrderByDetail(String detail);
    List<Order> findOrdersByAddress(String address);
    List<Order> findOrdersByUserUserId(Integer userId);

}
