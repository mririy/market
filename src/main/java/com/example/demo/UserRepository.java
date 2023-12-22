package com.example.demo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}