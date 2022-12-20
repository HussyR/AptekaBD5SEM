package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.OrderDto;
import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Medication;
import com.example.bdfinalproject.model.Order;

import java.util.List;

public interface OrderService {
    void save(OrderDto orderDto);
    List<Order> getAll();
    List<Order> getAllByClient(Client client);
    List<Medication> getMedicationByOrderId(long id);
}
