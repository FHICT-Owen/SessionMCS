package com.digitalmenu.sessionservice.Session;

import com.digitalmenu.sessionservice.exception.common.ElementAlreadyExistsException;
import com.digitalmenu.sessionservice.exception.common.NoSuchElementFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionBySecret(String secret) {
        return sessionRepository.findById(secret)
                .orElseThrow(() -> new NoSuchElementFoundException("Could not find any session with this id"));
    }

    public Session createSession(Session session) {
//        if (sessionRepository.existsByTableId(session.getTableId()))
//            throw new ElementAlreadyExistsException("This table is already in use");
        return sessionRepository.save(session);
    }

    public void deleteSessionById(String id) {
        if (!sessionRepository.existsById(id))
            throw new NoSuchElementFoundException("Could not find any session with this tableId");

        sessionRepository.deleteById(id);
    }
}
