package com.example.sessionmcs.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SessionService {
    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
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

    public void removeSession(Long id) {
        Optional<Session> session = getSessionById(id);
        if (!session.isPresent()) throw new IllegalStateException("Could not find any session with id: " + id);
            sessionRepository.deleteSessionById(id);
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findSessionById(id);
    }

    public Optional<Session> getSessionByTableId(Integer id) {
        return sessionRepository.findSessionByTableId(id);
    }

    public Optional<Session> getSessionBySecret(String secret) {
        return sessionRepository.findSessionBySecret(secret);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
