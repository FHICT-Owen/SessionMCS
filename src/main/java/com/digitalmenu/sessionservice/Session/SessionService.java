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

    public Optional<Session> getSessionBySecret(String secret) {
        return sessionRepository.findSessionBySecret(secret);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public void createSession(Session session) {
        sessionRepository.findSessionByTableId(session.getTableId())
                .orElseThrow(() -> new ElementAlreadyExistsException("No session found with this table id"));
        sessionRepository.save(session);
    }

    public void changeTable(Session session) {
        Optional<Session> exists = sessionRepository.findSessionById(session.getId());
        if (exists.isPresent()){
            Session actualSession = exists.get();
            actualSession.setTableId(session.getTableId());
            sessionRepository.save(actualSession);
        }
    }

    public void deleteSession(Long id) {
        if (!sessionRepository.existsById(id))
            throw new NoSuchElementFoundException("Could not find any session with tableId: " + id);
        sessionRepository.deleteSessionByTableId(id);
    }
}
