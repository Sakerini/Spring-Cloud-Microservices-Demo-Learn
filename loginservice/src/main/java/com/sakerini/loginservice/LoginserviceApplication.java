package com.sakerini.loginservice;

import com.sakerini.loginservice.entity.Credential;
import com.sakerini.loginservice.repository.CredentialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LoginserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginserviceApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(CredentialRepository credentialRepository) {
        return args -> {
            // Todo Replace plain text password strorage with hash password storage
            Credential admin = new Credential(1L,"admin", "admin", "USER");
            credentialRepository.save(admin);
        };
    }

}
