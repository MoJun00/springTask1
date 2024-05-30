package com.sparta.springtask1.repository;

import com.sparta.springtask1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    //Optional<User> findByUsername(String username);
}
