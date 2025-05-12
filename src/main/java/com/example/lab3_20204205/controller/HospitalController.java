package com.example.lab3_20204205.controller;

import com.example.lab3_20204205.entity.Doctor;
import com.example.lab3_20204205.entity.Hospital;
import com.example.lab3_20204205.entity.Paciente;
import com.example.lab3_20204205.repository.DoctorRepository;
import com.example.lab3_20204205.repository.HospitalRepository;
import com.example.lab3_20204205.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public HospitalController(HospitalRepository hospitalRepository,
                              DoctorRepository doctorRepository,
                              PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping({"", "/", "/list"})
    public String listarHospitales(Model model) {
        model.addAttribute("hospitales", hospitalRepository.findAll());
        return "hospital/list";
    }

    @GetMapping("/doctores/{id}")
    public String listarDoctoresPorHospital(@PathVariable("id") int id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        model.addAttribute("doctores", hospital != null ? doctorRepository.findByHospital(hospital) : null);
        return "hospital/listDoctoresXhospital";
    }

    @GetMapping("/pacientes/{id}")
    public String listarPacientesPorHospital(@PathVariable("id") int id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        model.addAttribute("pacientes", hospital != null ? pacienteRepository.findByHospital(hospital) : null);
        return "hospital/pacientesXhospital";
    }

}
