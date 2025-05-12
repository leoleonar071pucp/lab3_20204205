package com.example.lab3_20204205.repository;

import com.example.lab3_20204205.entity.Paciente;
import com.example.lab3_20204205.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByHospital(Hospital hospital);

    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId AND p.fechaCita > CURRENT_DATE")
    List<Paciente> findProximasCitasPorDoctor(@Param("doctorId") int doctorId);

    @Modifying
    @Query("UPDATE Paciente p SET p.doctor.id = :destinoId WHERE p.doctor.id = :origenId")
    void actualizarDoctorDePacientes(@Param("origenId") int origenId, @Param("destinoId") int destinoId);

    List<Paciente> findByDoctor_IdAndAtendidoFalse(int idDoctor);


}