package com.example.lab3_20204205.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "paciente")

public class paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPaciente;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "edad",  nullable = false)
    private Integer edad;

    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name = "diagnostico", length = 100)
    private String diagnostico;

    @Column(name = "fecha_cita")
    private Date fecha_cita;


    @Column(name = "numero_habitacion",  nullable = false)
    private Integer numero_habitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private hospital hospital;
}
