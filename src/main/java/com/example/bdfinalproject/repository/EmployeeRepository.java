package com.example.bdfinalproject.repository;

import com.example.bdfinalproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByPhoneNumber(String phone);
    Employee findEmployeeById(Long id);
}
