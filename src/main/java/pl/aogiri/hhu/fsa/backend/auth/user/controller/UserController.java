package pl.aogiri.hhu.fsa.backend.auth.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.auth.user.request.RegisterUserRequestDto;
import pl.aogiri.hhu.fsa.backend.auth.user.service.UserService;
import pl.aogiri.hhu.fsa.backend.common.exception.ApplicationException;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@Validated @RequestBody RegisterUserRequestDto request)
            throws ApplicationException {
        final var isUserCreated = userService.createNewUser(request);
        return isUserCreated ?
                ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.unprocessableEntity().build();
    }
}
