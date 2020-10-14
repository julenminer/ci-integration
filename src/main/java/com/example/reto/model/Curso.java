package com.example.reto.model;

public class Curso {
    private int id;
    private boolean activo;
    private String titulo;
    private Profesor profesor;
    private String nivel;
    private int horas;
    private String temarioUrl;

    public Curso(int id, boolean activo, String titulo, Profesor profesor, String nivel, int horas, String temarioUrl) {
        super();
        this.id = id;
        this.activo = activo;
        this.titulo = titulo;
        this.profesor = profesor;
        this.nivel = nivel;
        this.horas = horas;
        this.temarioUrl = temarioUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getNivel() {
        return nivel;
    }

    public int getHoras() {
        return horas;
    }

    public String getTemarioUrl() {
        return temarioUrl;
    }


}