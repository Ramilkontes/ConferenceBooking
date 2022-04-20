package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepositories extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}
