package com.example.lab3_20204205.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "doctor")
public class doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer doctorId;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "especialidad", length = 50, nullable = false)
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private hospital hospital;


}



