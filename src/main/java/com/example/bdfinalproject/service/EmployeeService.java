package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.dto.UserRegistrationDto;
import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(EmployeeDto employeeDto);
    Employee getEmployeeByPhone(String email);
//    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void update(EmployeeDto employeeDto);
    Employee getEmployeeById(Long id);
    void delete(Long id);
}
