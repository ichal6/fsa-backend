package pl.aogiri.hhu.fsa.backend.auth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aogiri.hhu.fsa.backend.auth.user.entity.PrivilegeEntity;

@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Long> {
}
