package com.example.lab3_20204205.repository;

import com.example.lab3_20204205.entity.Doctor;
import com.example.lab3_20204205.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByHospital(Hospital hospital);
}