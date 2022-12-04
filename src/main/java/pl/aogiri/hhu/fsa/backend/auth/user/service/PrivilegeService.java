package pl.aogiri.hhu.fsa.backend.auth.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.auth.user.entity.PrivilegeEntity;
import pl.aogiri.hhu.fsa.backend.auth.user.enums.Privilege;
import pl.aogiri.hhu.fsa.backend.auth.user.repository.PrivilegeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    public List<PrivilegeEntity> getDefaultsPrivileges() {
        final var defaultNames = Privilege.getDefaults().stream().map(Enum::toString).toList();
        return privilegeRepository.findAll()
                .stream()
                .filter(privilegeEntity -> defaultNames.contains(privilegeEntity.getName().name()))
                .toList();
    }
}
