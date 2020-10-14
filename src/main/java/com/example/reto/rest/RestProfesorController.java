package com.example.reto.rest;

import com.example.reto.model.Profesor;
import com.example.reto.ports.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestProfesorController {

    @Autowired
    ProfesorRepository profesorRepo;

    @GetMapping(path = "/profesores")
    public List<Profesor> getProfesores(){
        return profesorRepo.selectProfesores();
    }

}
