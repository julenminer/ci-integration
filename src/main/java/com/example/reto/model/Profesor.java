package com.example.reto.model;

public class Profesor {
    private int id;
    private String nombre;

    public Profesor(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
