package com.digitalmenu.sessionservice.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findSessionBySecret(String secret);
    Optional<Session> findSessionById(Long id);
    Optional<Session> findSessionByTableId(Integer id);
    Integer deleteSessionByTableId(Long tableId);
}
