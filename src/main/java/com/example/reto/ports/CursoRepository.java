package com.example.reto.ports;

import com.example.reto.model.Curso;

import java.util.List;

public interface CursoRepository {
    void addCurso(Curso curso);

    List<Curso> selectCursos(int page, int rows);

    int selectCursosCount();
}
