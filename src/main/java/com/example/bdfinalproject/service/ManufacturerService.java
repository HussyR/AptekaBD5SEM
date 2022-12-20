package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.dto.ManufacturerDto;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer save(ManufacturerDto manufacturerDto);
    Manufacturer getManufacturerByName(String name);
    //    Employee getEmployeeById(Long id);
    List<Manufacturer> getAllManufacturers();
    void delete(Long id);
}
