package com.digitalmenu.sessionservice.Session;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/session")
public class SessionController {

    private final SessionService sessionService;

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

    @GetMapping
    public List<Session> getSessions() { return sessionService.getAllSessions(); }

    @DeleteMapping("/sessionbytable/{tableId}")
//    @PreAuthorize("hasAuthority('delete:session')")
    public void deleteSessionById(@PathVariable("tableId") Long tableId) {
        sessionService.deleteSession(tableId);
    }
}