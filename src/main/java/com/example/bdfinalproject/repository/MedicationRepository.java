package com.example.bdfinalproject.repository;

import com.example.bdfinalproject.model.Manufacturer;
import com.example.bdfinalproject.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Medication findByName(String name);
}
