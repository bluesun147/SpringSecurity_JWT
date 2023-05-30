package com.example.jwtSecurity.user.repository;

import com.example.jwtSecurity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String email);

//    User findByUserEmail(String email);
}