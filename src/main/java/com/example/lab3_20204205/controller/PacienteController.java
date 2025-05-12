package com.example.lab3_20204205.controller;

import com.example.lab3_20204205.entity.Doctor;
import com.example.lab3_20204205.entity.Paciente;
import com.example.lab3_20204205.repository.DoctorRepository;
import com.example.lab3_20204205.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;

    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/list")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        return "paciente/list";
    }

    @GetMapping("/derivar")
    public String mostrarFormularioDerivar(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();
        model.addAttribute("doctores", doctores);
        return "paciente/derivar";
    }

    @PostMapping("/derivar")
    @Transactional
    public String derivarPacientes(@RequestParam("origenId") int origenId,
                                   @RequestParam("destinoId") int destinoId) {
        pacienteRepository.actualizarDoctorDePacientes(origenId, destinoId);
        return "redirect:/paciente/list";
    }
}
