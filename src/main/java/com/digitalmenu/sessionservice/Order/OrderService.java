package com.digitalmenu.sessionservice.Order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<FoodOrder> getOrders() {
        return orderRepository.findAll();
    }

    public List<FoodOrder> getOrdersBySessionId(String sessionId) {
        return orderRepository.getAllBySessionId(sessionId);
    }

    public FoodOrder createOrder(FoodOrder foodOrder) {
        return orderRepository.save(foodOrder);
    }

    public void updateOrder(FoodOrder foodOrder) {
        if (!orderRepository.existsFoodOrderBySessionIdAndTimeStamp(foodOrder.getSessionId(), foodOrder.getTimeStamp()))
            throw new EntityNotFoundException("Order not found!");
        orderRepository.save(foodOrder);
    }

    public void deleteOrder(FoodOrder foodOrder) {
        if (!orderRepository.existsFoodOrderBySessionIdAndTimeStamp(
                foodOrder.getSessionId(), foodOrder.getTimeStamp()))
            throw new EntityNotFoundException("Order does not exist!");

        orderRepository.deleteFoodOrderBySessionIdAndTimeStamp(
                foodOrder.getSessionId(), foodOrder.getTimeStamp());
    }

    public void deleteOrdersBySessionId(String sessionId) {
        if (!orderRepository.existsFoodOrderBySessionId(sessionId))
            throw new EntityNotFoundException("Session does not have any orders!");

        orderRepository.deleteFoodOrdersBySessionId(sessionId);
    }
}
