package com.example.sessionmcs.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findSessionByMacAddress(String macAddress);
    Optional<Session> findSessionById(Long id);
    List<Session> findSessionsByRestaurantId(Integer restaurantId);
    Integer deleteSessionById(Long id);
}
