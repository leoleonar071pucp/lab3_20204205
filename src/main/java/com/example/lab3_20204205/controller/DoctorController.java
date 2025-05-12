package com.example.lab3_20204205.controller;

import com.example.lab3_20204205.entity.Doctor;
import com.example.lab3_20204205.entity.Paciente;
import com.example.lab3_20204205.repository.DoctorRepository;
import com.example.lab3_20204205.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public DoctorController(DoctorRepository doctorRepository,
                            PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping({"", "/", "/list"})
    public String listarDoctores(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        return "doctor/list";
    }

    @GetMapping("/citas/{id}")
    public String listarPacientesNoAtendidos(@PathVariable("id") int id, Model model) {
        List<Paciente> pendientes = pacienteRepository.findByDoctor_IdAndAtendidoFalse(id);
        model.addAttribute("pacientesPendientes", pendientes);
        return "doctor/citasPendientes";
    }
}
