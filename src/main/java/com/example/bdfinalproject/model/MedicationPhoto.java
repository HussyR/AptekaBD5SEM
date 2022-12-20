package com.example.bdfinalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medication_photo")
@Data
@NoArgsConstructor
public class MedicationPhoto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medication medication;

    public MedicationPhoto(String url, Medication medication) {
        this.url = url;
        this.medication = medication;
    }
}
