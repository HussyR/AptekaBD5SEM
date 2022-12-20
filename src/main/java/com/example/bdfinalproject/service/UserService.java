package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.UserRegistrationDto;
import com.example.bdfinalproject.model.Client;

import java.util.List;

public interface UserService {
    Client save(UserRegistrationDto user);
    Client getUserByEmail(String email);
    List<Client> getAllUsers();
}
