package com.example.bdfinalproject.dto;

import com.example.bdfinalproject.model.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    private Long id;
    private String name;
    private String price;
    private String description;
    private Manufacturer manufacturer;
    private Long manufacturerId;
}