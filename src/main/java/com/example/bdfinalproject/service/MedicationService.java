package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.ManufacturerDto;
import com.example.bdfinalproject.dto.MedicationDto;
import com.example.bdfinalproject.model.Manufacturer;
import com.example.bdfinalproject.model.Medication;

import java.util.List;

public interface MedicationService {
    Medication save(MedicationDto medicationDto);
    Medication getMedicationByName(String name);
    //    Employee getEmployeeById(Long id);
    List<Medication> getAllMedications();
    void delete(Long id);
}
