package com.example.lab3_20204205.repository;

import com.example.lab3_20204205.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}