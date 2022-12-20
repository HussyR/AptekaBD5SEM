package com.example.bdfinalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medication")
@Data
@NoArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    private String price;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medication", fetch=FetchType.LAZY)
    private List<MedicationPhoto> medicationPhotos;

    public Medication(String name, String price, String description, Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}