package com.example.bdfinalproject.dto;

import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String date;
    private List<Medication> medications;
    private Employee employee;
    private Client client;
    private Long manufacturerId;
    private Long clientId;
    private List<Integer> array;
    private Long sum;
}