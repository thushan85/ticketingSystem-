package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNic(String nic);

    boolean existsByEmail(String email);
}
