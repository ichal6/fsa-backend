package pl.aogiri.hhu.fsa.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.aogiri.hhu.fsa.backend.auth.security.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties({RsaKeyProperties.class})
public class FsaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsaBackendApplication.class, args);
    }

}
