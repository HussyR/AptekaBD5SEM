package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.dto.ManufacturerDto;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Manufacturer;
import com.example.bdfinalproject.repository.EmployeeRepository;
import com.example.bdfinalproject.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer save(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer(
                manufacturerDto.getName(),
                manufacturerDto.getAddress()
        );
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer getManufacturerByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
