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
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<FoodOrder> getOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(FoodOrder foodOrder) {
        if (foodOrder.getDishes().isEmpty()) throw new IllegalStateException("Order is empty!");
        if (foodOrder.getIsApproved()) throw new IllegalStateException("Order can't be approved!");
        if (foodOrder.getIsCanceled()) throw new IllegalStateException("Order can't be canceled!");
        if (foodOrder.getIsBeingPrepared()) throw new IllegalStateException("Order can't be being prepared!");
        if (foodOrder.getIsReady()) throw new IllegalStateException("Order can't be ready!");

        orderRepository.save(foodOrder);
    }

    public void approveOrder(FoodOrder foodOrder) {
        var order = orderRepository.getFoodOrderBySessionIdAndTimeStamp(
                foodOrder.getSessionId(), foodOrder.getTimeStamp()
            ).orElseThrow(() -> new EntityNotFoundException("Order not found!")
        );
        if (order.getIsApproved())
            throw new EntityExistsException("Order already approved!");

        order.approveOrder();

        orderRepository.save(order);
    }

    public void removeOrder(FoodOrder foodOrder) {
        if (!orderRepository.existsFoodOrderBySessionIdAndTimeStamp(
                foodOrder.getSessionId(), foodOrder.getTimeStamp()))
            throw new EntityNotFoundException("Order does not exist!");

        orderRepository.deleteFoodOrderBySessionIdAndTimeStamp(
                foodOrder.getSessionId(), foodOrder.getTimeStamp());
    }

    public void removeOrdersBySessionId(Integer sessionId) {
        if (!orderRepository.existsFoodOrderBySessionId(sessionId))
            throw new EntityNotFoundException("Session does not have any orders!");

        orderRepository.deleteFoodOrdersBySessionId(sessionId);
    }
}
