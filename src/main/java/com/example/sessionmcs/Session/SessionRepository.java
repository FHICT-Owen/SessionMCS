package com.example.sessionmcs.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findSessionBySecret(String secret);
    Optional<Session> findSessionById(Long id);
    Optional<Session> findSessionByTableId(Integer id);
    Integer deleteSessionById(Long id);
}
