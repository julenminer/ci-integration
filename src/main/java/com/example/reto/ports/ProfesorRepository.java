package com.example.reto.ports;

import com.example.reto.model.Profesor;

import java.util.List;

public interface ProfesorRepository {
    List<Profesor> selectProfesores();
}
