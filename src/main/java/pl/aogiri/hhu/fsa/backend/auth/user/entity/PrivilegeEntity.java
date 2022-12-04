package pl.aogiri.hhu.fsa.backend.auth.user.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import pl.aogiri.hhu.fsa.backend.auth.user.enums.Privilege;
import pl.aogiri.hhu.fsa.backend.auth.user.utils.PrivilegeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "privilege")
public class PrivilegeEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Convert(converter = PrivilegeConverter.class)
    private Privilege name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}