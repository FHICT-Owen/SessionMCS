package com.example.sessionmcs.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        Optional<Session> checkTable = sessionService.getSessionByTableId(session.getTableId());
        if(checkTable.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        sessionService.createSession(session);
        return new ResponseEntity<>(session, HttpStatus.CREATED);
    }

    @GetMapping("/sessionbycookie")
    public Optional<Session> getSessionByCookie(@RequestParam String cookie) { return sessionService.getSessionBySecret(cookie); }

    @DeleteMapping("/sessionbytable/{tableId}")
    public void deleteSessionById(@PathVariable("tableId") Integer tableId) {
        sessionService.removeSession(tableId);
    }
}
