package pl.aogiri.hhu.fsa.backend.auth.user.request;

import pl.aogiri.hhu.fsa.backend.auth.user.enums.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public record RegisterUserRequestDto(String email, String password, String name,
                                     String surname,
                                     @Enumerated(EnumType.STRING) Gender gender,
                                     String country, LocalDate dateOfBirth) {
}
