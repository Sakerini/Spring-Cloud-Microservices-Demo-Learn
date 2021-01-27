package com.sakerini.loginservice.repository;

import com.sakerini.loginservice.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
}
