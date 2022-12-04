package pl.aogiri.hhu.fsa.backend.auth.user.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.aogiri.hhu.fsa.backend.auth.user.entity.UserEntity;
import pl.aogiri.hhu.fsa.backend.auth.user.request.RegisterUserRequestDto;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserEntity toEntity(RegisterUserRequestDto requestDto) {
        final var userEntity = new UserEntity();
        userEntity.setEmail(requestDto.email());
        userEntity.setPassword(passwordEncoder.encode(requestDto.password()));
        userEntity.setName(requestDto.name());
        userEntity.setSurname(requestDto.surname());
        userEntity.setGender(requestDto.gender());
        userEntity.setDateOfBirth(requestDto.dateOfBirth());
        userEntity.setCountry(requestDto.country());
        userEntity.setEnabled(true);
        return userEntity;
    }
}
