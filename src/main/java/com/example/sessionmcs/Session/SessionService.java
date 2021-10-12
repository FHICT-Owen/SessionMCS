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

    public void removeSession(Long id, Integer restaurantId) {
        Optional<Session> session = getSessionById(id);
        if (!session.isPresent()) throw new IllegalStateException("Could not find any session with id: " + id);
        boolean match = session.stream().anyMatch(target -> restaurantId.equals(target.getRestaurantId()));
        if (match) {
            sessionRepository.deleteSessionById(id);
        } else {
            throw new IllegalStateException("Restaurant id does not match the restaurant id of the given object. Can not remove session!");
        }
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findSessionById(id);
    }

    public Optional<Session> getSessionByMac(String mac) {
        return sessionRepository.findSessionByMacAddress(mac);
    }

    public List<Session> getAllSessionsByRestaurantId(Integer restaurantId) {
        return sessionRepository.findSessionsByRestaurantId(restaurantId);
    }
}
