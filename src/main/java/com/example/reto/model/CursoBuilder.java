package com.example.reto.model;

public class CursoBuilder {
    private int id;
    private boolean activo;
    private String titulo;
    private Profesor profesor;
    private String nivel;
    private int horas;
    private String temarioUrl;

    public Curso build() {
        return new Curso(id,
                activo,
                titulo,
                profesor,
                nivel,
                horas,
                temarioUrl);
    }

    public CursoBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CursoBuilder activo(boolean activo) {
        this.activo = activo;
        return this;
    }

    public CursoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CursoBuilder profesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }

    public CursoBuilder nivel(String nivel) {
        this.nivel = nivel;
        return this;
    }

    public CursoBuilder horas(int horas) {
        this.horas = horas;
        return this;
    }

    public CursoBuilder temarioUrl(String temarioUrl) {
        this.temarioUrl = temarioUrl;
        return this;
    }

}