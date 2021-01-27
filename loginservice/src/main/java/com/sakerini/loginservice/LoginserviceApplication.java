package com.sakerini.loginservice;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.repository.CredentialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CredentialRepository credentialRepository) {
        return args -> {
            Credential admin = new Credential("admin", "admin");
            credentialRepository.save(admin);
        };
    }

}
