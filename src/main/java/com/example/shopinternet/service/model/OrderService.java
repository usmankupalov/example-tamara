package com.example.shopinternet.service.model;

import com.example.shopinternet.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    Order findOrderByDetail(String detailName);
    Order findOrderByOrderId(Integer orderId);
    List<Order> findOrdersByAddress(String address);
    List<Order> findOrdersByUserUserId(Integer userId);
}
