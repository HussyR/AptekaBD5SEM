package com.example.bdfinalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="manufacturer")
@Data
@NoArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch=FetchType.LAZY)
    private List<Medication> medicationList;

    public Manufacturer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
