package com.example.lab3_20204205.repository;

import com.example.lab3_20204205.entity.doctor;
import com.example.lab3_20204205.entity.paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface doctorRepository extends JpaRepository<doctor, Integer> {




    @Query("SELECT p FROM paciente p WHERE p.doctor.id = ?1")
    List<paciente> listarPacientesPorDoctor(int doctorId);




}
