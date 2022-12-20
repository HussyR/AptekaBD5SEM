package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.UserRegistrationDto;
import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Role;
import com.example.bdfinalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Client save(UserRegistrationDto registrationDto) {
        String phone = "+79999991212";
        Client user = new Client(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                phone,
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);
    }

    @Override
    public Client getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Client> getAllUsers() {
        return userRepository.findAll();
    }
}
