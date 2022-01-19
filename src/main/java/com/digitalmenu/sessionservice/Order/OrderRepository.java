package com.digitalmenu.sessionservice.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<FoodOrder, Integer> {
    boolean existsFoodOrderBySessionIdAndTimeStamp(String sessionId, Long timeStamp);
    boolean existsFoodOrderBySessionId(String id);
    void deleteFoodOrderBySessionIdAndTimeStamp(String sessionId, Long timeStamp);
    void deleteFoodOrdersBySessionId(String sessionId);
    List<FoodOrder> getAllBySessionId(String sessionId);
}
