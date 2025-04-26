package com.example.lab3_20204205.repository;
import com.example.lab3_20204205.entity.hospital;
import com.example.lab3_20204205.entity.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface  hospitalRepository  extends JpaRepository<hospital, Integer> {

    @Query("""
        SELECT * FROM doctor  where doctor.hospital_id = ?1
        
    """)
    List<doctor> buscarDoctoresPorHospital(int id);

    @Query("""
        SELECT  * FROM paciente  where paciente.hospital_id = ?1
        
    """)
    List<doctor> listarpacientesPorHospital(int id);




}


