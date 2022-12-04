package pl.aogiri.hhu.fsa.backend.auth.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import pl.aogiri.hhu.fsa.backend.auth.user.entity.UserEntity;
import pl.aogiri.hhu.fsa.backend.auth.user.exception.EmailAlreadyUsed;
import pl.aogiri.hhu.fsa.backend.auth.user.repository.UserRepository;
import pl.aogiri.hhu.fsa.backend.auth.user.request.RegisterUserRequestDto;
import pl.aogiri.hhu.fsa.backend.auth.user.utils.UserMapper;
import pl.aogiri.hhu.fsa.backend.common.exception.ApplicationException;

import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PrivilegeService privilegeService;
    private final UserMapper userMapper;


    public boolean createNewUser(RegisterUserRequestDto request) throws ApplicationException {
        final var email = request.email();

        if (isEmailAlreadyUsed(email)) {
            throw new EmailAlreadyUsed();
        }

        final var userEntity = userMapper.toEntity(request);
        setDefaultPrivileges(userEntity);
        userRepository.save(userEntity);

        return !ObjectUtils.isEmpty(userEntity.getId());
    }

    private boolean isEmailAlreadyUsed(String email) {
        return userRepository.existsByEmail(email);
    }

    private void setDefaultPrivileges(UserEntity user) {
        final var defaults = privilegeService.getDefaultsPrivileges();
        user.setPrivileges(new HashSet<>(defaults));
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
