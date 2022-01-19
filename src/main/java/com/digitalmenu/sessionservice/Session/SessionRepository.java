package com.digitalmenu.sessionservice.Session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
}
