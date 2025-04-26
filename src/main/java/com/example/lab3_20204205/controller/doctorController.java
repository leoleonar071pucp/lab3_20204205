package com.example.lab3_20204205.controller;


import com.example.lab3_20204205.entity.paciente;
import com.example.lab3_20204205.entity.doctor;
import com.example.lab3_20204205.entity.hospital;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.lab3_20204205.repository.hospitalRepository;
import com.example.lab3_20204205.repository.doctorRepository;
import com.example.lab3_20204205.repository.pacienteRepository;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctor")

public class doctorController {

    final hospitalRepository hospitalRepository;
    final doctorRepository doctorRepository;
    final pacienteRepository pacienteRepository;

    public doctorController(hospitalRepository hospitalRepository,doctorRepository doctorRepository,pacienteRepository pacienteRepository) {

        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;

    }

    @GetMapping(value = {"/list", ""})
    public String hello(Model model) {

        model.addAttribute("doctorList", doctorRepository.findAll());


        return "doctorList";
    }


    @GetMapping("/listarPacientesPorDoctor")
    public String listarPacientesPorDoctor(Model model,@RequestParam("id") int id) {

        Optional<doctor> optionalDoctor = doctorRepository.findById(id);

        if (optionalDoctor.isPresent()) {
            doctor doctor = optionalDoctor.get();
            model.addAttribute("listarPacientesPorDoctor", doctorRepository.listarPacientesPorDoctor(id));
            return "listarPacientesPorDoctor";
        } else {
            return "redirect:/doctor/list";
        }


    }


}
