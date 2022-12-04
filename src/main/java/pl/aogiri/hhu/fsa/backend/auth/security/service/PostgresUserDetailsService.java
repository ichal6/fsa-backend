package pl.aogiri.hhu.fsa.backend.auth.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.auth.user.repository.UserRepository;

import javax.transaction.Transactional;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class PostgresUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(format("Not found user for %s username", username)));
    }


}
