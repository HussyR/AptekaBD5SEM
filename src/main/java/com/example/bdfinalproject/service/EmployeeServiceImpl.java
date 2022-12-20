package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.repository.EmployeeRepository;
import com.example.bdfinalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getPhone()
        );
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByPhone(String phone) {
        return employeeRepository.findByPhoneNumber(phone);
    }

//    @Override
//    public Employee getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getPhone());
        employee.setId(employeeDto.getId());
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
