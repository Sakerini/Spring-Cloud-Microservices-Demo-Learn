package com.sakerini.tokenservice.repository;

import com.sakerini.tokenservice.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
