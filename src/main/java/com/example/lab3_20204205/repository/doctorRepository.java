package com.example.lab3_20204205.repository;

import com.example.lab3_20204205.entity.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface doctorRepository extends JpaRepository<doctor, Integer> {




    @Query("""
        SELECT  * FROM paciente  where paciente.doctor_id = ?1
        
    """)
    List<doctor> listarPacientesPorDoctor(int doctorId);



}
