package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.model.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByNic(String nic);

    boolean existsByEmail(String email);

    Optional<User> findUserByMobileNumberAndUserType(String mobileNo, UserType useType);
}
