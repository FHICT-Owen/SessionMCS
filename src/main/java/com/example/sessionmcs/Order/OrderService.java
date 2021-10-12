package com.example.sessionmcs.Order;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(Order order) {
        order.setApproved(false);
        orderRepository.save(order);
    }

    public void approveOrder(Order order) {
        order.setApproved(true);
        orderRepository.save(order);
    }

    public void removeOrder(Long id) {
        orderRepository.deleteOrderById(id);
    }

    public void removeOrdersBySessionId(Integer sessionId) {
        orderRepository.deleteOrdersBySessionId(sessionId);
    }
}
