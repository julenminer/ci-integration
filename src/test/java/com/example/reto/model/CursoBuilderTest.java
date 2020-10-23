package com.example.reto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoBuilderTest {

    @Test
    void build() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertNotNull(emptyCurso);
        assertEquals(emptyCurso.getId(), 0);
    }

    @Test
    void id() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertEquals(emptyCurso.getId(), 0);
        Curso cursoWithId = cursoBuilder.id(1).build();
        assertEquals(cursoWithId.getId(), 1);
    }

    @Test
    void active() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertFalse(emptyCurso.isActivo());
        Curso cursoWithActivo = cursoBuilder.active(true).build();
        assertTrue(cursoWithActivo.isActivo());
    }

    @Test
    void title() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertNull(emptyCurso.getTitulo());
        Curso cursoWithTitulo = cursoBuilder.title("title").build();
        assertEquals(cursoWithTitulo.getTitulo(), "title");
    }

    @Test
    void teacher() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertNull(emptyCurso.getProfesor());
        Curso cursoWithProfesor = cursoBuilder.teacher(new Profesor(0,"teacher")).build();
        assertEquals(cursoWithProfesor.getProfesor().getId(), 0);
        assertEquals(cursoWithProfesor.getProfesor().getNombre(), "teacher");
    }

    @Test
    void level() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertNull(emptyCurso.getTitulo());
        Curso cursoWithNivel = cursoBuilder.level("level").build();
        assertEquals(cursoWithNivel.getNivel(), "level");
    }

    @Test
    void hours() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertEquals(emptyCurso.getHoras(), 0);
        Curso cursoWithHours = cursoBuilder.hours(1).build();
        assertEquals(cursoWithHours.getHoras(), 1);
    }

    @Test
    void syllabusUrl() {
        CursoBuilder cursoBuilder = new CursoBuilder();
        Curso emptyCurso = cursoBuilder.build();
        assertNull(emptyCurso.getTemarioUrl());
        Curso cursoWithSyllabus = cursoBuilder.syllabusUrl("url").build();
        assertEquals(cursoWithSyllabus.getTemarioUrl(), "url");
    }
}