package com.example.bdfinalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="ordera", uniqueConstraints = @UniqueConstraint(columnNames = "date"))
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ordera_medication",
            joinColumns = @JoinColumn(
                    name = "ordera_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "medication_id", referencedColumnName = "id"))
    private Collection<Medication> medications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(String date, Employee employee, Client client, Collection<Medication> medications) {
        this.date = date;
        this.employee = employee;
        this.client = client;
        this.medications = medications;
    }
}

