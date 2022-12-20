package com.example.bdfinalproject.dto;

import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Medication;
import com.example.bdfinalproject.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String name;
    private List<OrderDto> orders;
    private Employee employee;
    private Long sum;
}