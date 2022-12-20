package com.example.bdfinalproject.repository;

import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Manufacturer;
import com.example.bdfinalproject.service.ManufacturerService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
    Manufacturer findManufacturerById(Long id);
}