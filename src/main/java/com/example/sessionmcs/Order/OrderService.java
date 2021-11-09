package com.example.sessionmcs.Order;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public List<FoodOrder> getOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(FoodOrder foodOrder) {
        foodOrder.setApproved(false);
        orderRepository.save(foodOrder);
    }

    public void approveOrder(FoodOrder foodOrder) {
        foodOrder.setApproved(true);
        orderRepository.save(foodOrder);
    }

    public void removeOrder(Long id) {
        orderRepository.deleteOrderById(id);
    }

    public void removeOrdersBySessionId(Integer sessionId) {
        orderRepository.deleteOrdersBySessionId(sessionId);
    }
}
