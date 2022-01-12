package com.digitalmenu.sessionservice.Session;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/session")
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    @PreAuthorize("hasAuthority('access:session')")
    public List<Session> getSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/sessionbycookie")
    public Optional<Session> getSessionByCookie(@RequestParam String cookie) {
        return sessionService.getSessionBySecret(cookie);
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody @Valid Session session) {
        sessionService.createSession(session);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/sessionbytable/{tableId}")
    @PreAuthorize("hasAuthority('access:session')")
    public void deleteSessionById(@PathVariable("tableId") Long tableId) {
        sessionService.deleteSession(tableId);
    }
}
