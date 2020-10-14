package com.example.reto.repository;

import com.example.reto.mapper.MyBatisProfesorMapper;
import com.example.reto.model.Profesor;
import com.example.reto.ports.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "MyBatisProfesorRepository")
public class MyBatisProfesorRepository implements ProfesorRepository {

    @Autowired
    MyBatisProfesorMapper profesorAccess;

    @Override
    public List<Profesor> selectProfesores() {
        return profesorAccess.selectProfesores();
    }

}
