package com.example.bdfinalproject.repository;

import com.example.bdfinalproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
