package pl.aogiri.hhu.fsa.backend.auth.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.auth.security.service.JwtTokenService;

import static java.lang.String.format;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final JwtTokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity<String> requestForToken(Authentication authentication) {
        log.debug(format("Token requested for user [%s]", authentication.getName()));
        final var token = tokenService.generateToken(authentication);
        log.debug(format("Token [%s] granted for user [%s]", token, authentication.getName()));
        return ResponseEntity.ok(token);
    }
}
