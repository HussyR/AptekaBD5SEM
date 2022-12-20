package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.MedicationDto;
import com.example.bdfinalproject.model.Medication;
import com.example.bdfinalproject.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public Medication save(MedicationDto medicationDto) {
        Medication medication = new Medication(
                medicationDto.getName(),
                medicationDto.getPrice(),
                medicationDto.getDescription(),
                medicationDto.getManufacturer()
        );
        return medicationRepository.save(medication);
    }

    @Override
    public Medication getMedicationByName(String name) {
        return medicationRepository.findByName(name);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        medicationRepository.deleteById(id);
    }

}
