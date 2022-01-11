package com.digitalmenu.sessionservice.Session;

import com.digitalmenu.sessionservice.exception.common.NoSuchElementFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Optional<Session> getSessionByTableId(Integer id) {
        return sessionRepository.findSessionByTableId(id);
    }

    public Optional<Session> getSessionBySecret(String secret) {
        return sessionRepository.findSessionBySecret(secret);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findSessionById(id);
    }

    public void createSession(Session session) {
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
