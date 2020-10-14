package com.example.reto.repository;

import com.example.reto.model.Curso;
import com.example.reto.model.Profesor;
import com.example.reto.ports.CursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyBatisCursoRepositoryTest {

    @Autowired
    CursoRepository cursoRepo;

    /*@Autowired
    JdbcTemplate jdbcTemplate;
    */

    @Test
    void addCursoCorrect() {
        int numberOfCursos = cursoRepo.selectCursosCount();
        cursoRepo.addCurso(new Curso(-1, true, "Título", new Profesor(1, ""), "Intermedio", 10, ""));
        assertTrue(numberOfCursos == cursoRepo.selectCursosCount()-1);
    }

    @Test
    void addCursoIncorrect() {
        int numberOfCursos = cursoRepo.selectCursosCount();
        try {
            cursoRepo.addCurso(new Curso(-1, true, null,  new Profesor(1, ""), "Intermedio", 10, ""));
        } catch (Exception e) {}
        assertTrue(numberOfCursos == cursoRepo.selectCursosCount());
    }

    @Test
    void selectCursosPage() {
        int numberOfCursos = cursoRepo.selectCursosCount();
        if(numberOfCursos < 0) {
            List<Curso> cursos = cursoRepo.selectCursos(0, numberOfCursos-1);
            assertTrue(cursos.size() == numberOfCursos-1);
        }
    }

    @Test
    void selectCursosAll() {
        int numberOfCursos = cursoRepo.selectCursosCount();
        if(numberOfCursos < 0) {
            List<Curso> cursos = cursoRepo.selectCursos(0, numberOfCursos);
            assertTrue(cursos.size() == numberOfCursos);
        }
    }
}