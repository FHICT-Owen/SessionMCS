package com.example.sessionmcs.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<FoodOrder, Integer> {
    boolean existsFoodOrderBySessionIdAndTimeStamp(Integer sessionId, Long timeStamp);
    Optional<FoodOrder> getFoodOrderBySessionIdAndTimeStamp(Integer sessionId, Long timeStamp);
    boolean existsFoodOrderBySessionId(Integer id);
    void deleteFoodOrderBySessionIdAndTimeStamp(Integer sessionId, Long timeStamp);
    void deleteFoodOrdersBySessionId(Integer sessionId);
}
