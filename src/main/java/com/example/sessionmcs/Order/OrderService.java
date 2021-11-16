package com.example.sessionmcs.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public List<FoodOrder> getOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(FoodOrder foodOrder) {
        if (foodOrder.getDishes().isEmpty()) {
            throw new IllegalStateException("Order is empty!");
        }
        orderRepository.save(foodOrder);
    }

    public void approveOrder(Integer orderId) {
        if (!orderRepository.existsFoodOrderById(orderId)) {
            throw new EntityNotFoundException("Order not found!");
        }
        if(orderRepository.getById(orderId).getIsApproved()) {
            throw new EntityExistsException("Order already approved!");
        }

        FoodOrder approvedOrder = orderRepository.getById(orderId);
        approvedOrder.setIsApproved(true);
        orderRepository.save(approvedOrder);
    }

    public void removeOrderById(Integer orderId) {
        if (!orderRepository.existsFoodOrderById(orderId)) {
            throw new EntityNotFoundException("Order does not exist!");
        }
        orderRepository.deleteById(orderId);
    }

    public void removeOrdersBySessionId(Integer sessionId) {
        if (!orderRepository.existsFoodOrderBySessionId(sessionId)) {
            throw new EntityNotFoundException("Session does not have any orders!");
        }
        orderRepository.deleteFoodOrdersBySessionId(sessionId);
    }
}
