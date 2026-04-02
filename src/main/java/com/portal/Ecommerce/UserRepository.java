package com.portal.Ecommerce;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {
    Optional<UserDTO> findByEmail(String email);
}