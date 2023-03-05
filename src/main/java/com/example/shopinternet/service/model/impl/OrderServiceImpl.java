package com.example.shopinternet.service.model.impl;

import com.example.shopinternet.model.Order;
import com.example.shopinternet.repository.model.OrderRepository;
import com.example.shopinternet.service.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        Date date = new Date();
        order.setAddress(order.getAddress());
        order.setAmountDetail(order.getAmountDetail());
        order.setDetail(order.getDetail());
        order.setTotalSum(order.getTotalSum());
        order.setRegisteredTime(date);
        orderRepository.save(order);
    }

    @Override
    public Order findOrderByDetail(String detailName) {
        return orderRepository.findOrderByDetail(detailName);
    }

    @Override
    public Order findOrderByOrderId(Integer orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    @Override
    public List<Order> findOrdersByAddress(String address) {
        return orderRepository.findOrdersByAddress(address);
    }

    @Override
    public List<Order> findOrdersByUserUserId(Integer userId) {
        return orderRepository.findOrdersByUserUserId(userId);
    }
}
