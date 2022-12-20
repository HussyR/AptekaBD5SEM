package com.example.bdfinalproject.service;

import com.example.bdfinalproject.dto.OrderDto;
import com.example.bdfinalproject.model.Client;
import com.example.bdfinalproject.model.Medication;
import com.example.bdfinalproject.model.Order;
import com.example.bdfinalproject.repository.MedicationRepository;
import com.example.bdfinalproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MedicationRepository medicationRepository;

    public OrderServiceImpl(OrderRepository orderRepository, MedicationRepository medicationRepository) {
        this.orderRepository = orderRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public void save(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getDate(),
                orderDto.getEmployee(),
                orderDto.getClient(),
                new ArrayList<>()
        );
        orderRepository.save(order);

        List<Medication> medications = medicationRepository.findAll();
        List<Medication> list = new ArrayList<Medication>(order.getMedications());

        // array
        for (int i = 0; i < orderDto.getArray().size(); i++) {
            for (int j = 0; j < orderDto.getArray().get(i); j++) {
                list.add(medications.get(i));
            }
        }
        order.setMedications(list);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllByClient(Client client) {
        return orderRepository
                .findAll()
                .stream()
                .filter(o -> o.getClient().getEmail().equals(client.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Medication> getMedicationByOrderId(long id) {
        return new ArrayList<>(orderRepository.findOrderById(id).getMedications());
    }

}
