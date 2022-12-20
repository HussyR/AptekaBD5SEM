package com.example.bdfinalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch=FetchType.LAZY)
    private List<Order> orders;

    public Employee(String first_name, String last_name, String phone_number) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.phoneNumber = phone_number;
    }
}
