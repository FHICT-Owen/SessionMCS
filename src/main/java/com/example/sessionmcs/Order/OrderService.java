package com.example.sessionmcs.Order;

import com.example.sessionmcs.Dish.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        boolean existsBySessionIdAndDishes = orderRepository.existsBySessionIdAndDishesIn(foodOrder.getSessionId(),foodOrder.getDishes());
        if (existsBySessionIdAndDishes) {
            throw new EntityExistsException("Order already made!");
        }
        foodOrder.setApproved(false);
        orderRepository.save(foodOrder);
    }

    public void approveOrder(Integer sessionId, List<Dish> dishes) {
        Optional<FoodOrder> orderBySessionIdAndDishes = orderRepository.findFoodOrderBySessionIdAndDishesIn(sessionId, dishes);
        if (orderBySessionIdAndDishes.isEmpty()) {
            throw new EntityNotFoundException("Order not found!");
        }
        if(orderBySessionIdAndDishes.get().getApproved()) {
            throw new EntityExistsException("Order already approved!");
        }
        FoodOrder approvedOrder = orderBySessionIdAndDishes.get();
        approvedOrder.setApproved(true);
        orderRepository.save(approvedOrder);
    }

    public void removeOrderBySessionIdAndDishes(Integer sessionId, List<Dish> dishes) {
        boolean existsBySessionIdAndDishes = orderRepository.existsBySessionIdAndDishesIn(sessionId,dishes);
        if (!existsBySessionIdAndDishes) {
            throw new EntityNotFoundException("Order does not exist!");
        }
        orderRepository.deleteOrderBySessionIdAndDishesIn(sessionId,dishes);
    }

    public void removeOrdersBySessionId(Integer sessionId) {
        boolean existsBySessionId = orderRepository.existsBySessionId(sessionId);
        if (!existsBySessionId) {
            throw new EntityNotFoundException("Session with Session ID " + sessionId + " does not have any orders!");
        }
        orderRepository.deleteOrdersBySessionId(sessionId);
    }
}
