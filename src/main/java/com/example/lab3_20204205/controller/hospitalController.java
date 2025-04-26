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

@RequestMapping("/hospital")

public class hospitalController {

    final hospitalRepository hospitalRepository;
    final doctorRepository doctorRepository;
    final pacienteRepository pacienteRepository;

    public hospitalController(hospitalRepository hospitalRepository,doctorRepository doctorRepository,pacienteRepository pacienteRepository) {

        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;

    }

    @GetMapping(value = {"/list", ""})
    public String hello(Model model) {

        model.addAttribute("listaHospitales", hospitalRepository.findAll());


        return "hospitalList";
    }

    @GetMapping("/listarDoctoresPorHospital")
    public String listarDoctoresPorHospital(Model model,@RequestParam("id") int id) {

        Optional<hospital> optionalHospital = hospitalRepository.findById(id);

        if (optionalHospital.isPresent()) {
            hospital hospital = optionalHospital.get();
            model.addAttribute("listarDoctoresPorHospital", hospitalRepository.buscarDoctoresPorHospital(id));
            return "listarDoctoresPorHospital";
        } else {
            return "redirect:/hospital/list";
        }


    }

    @GetMapping("/listarpacientesPorHospital")
    public String listarpacientesPorHospital(Model model,@RequestParam("id") int id) {

        Optional<hospital> optionalHospital = hospitalRepository.findById(id);

        if (optionalHospital.isPresent()) {
            hospital hospital = optionalHospital.get();
            model.addAttribute("listarpacientesPorHospital", hospitalRepository.listarpacientesPorHospital(id));
            return "listarpacientesPorHospital";
        } else {
            return "redirect:/hospital/list";
        }


    }


}
