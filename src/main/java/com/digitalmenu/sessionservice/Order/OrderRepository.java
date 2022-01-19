package com.digitalmenu.sessionservice.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<FoodOrder, Integer> {
    boolean existsFoodOrderBySessionIdAndTimeStamp(String sessionId, Long timeStamp);
    Optional<FoodOrder> getFoodOrderBySessionIdAndTimeStamp(String sessionId, Long timeStamp);
    boolean existsFoodOrderBySessionId(String id);
    void deleteFoodOrderBySessionIdAndTimeStamp(String sessionId, Long timeStamp);
    void deleteFoodOrdersBySessionId(String sessionId);
}
