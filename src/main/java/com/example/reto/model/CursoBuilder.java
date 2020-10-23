package com.example.reto.model;

public class CursoBuilder {
    private int id;
    private boolean active;
    private String title;
    private Profesor teacher;
    private String level;
    private int hours;
    private String syllabusUrl;

    public Curso build() {
        return new Curso(id,
                active,
                title,
                teacher,
                level,
                hours,
                syllabusUrl);
    }

    public CursoBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CursoBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public CursoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public CursoBuilder teacher(Profesor teacher) {
        this.teacher = teacher;
        return this;
    }

    public CursoBuilder level(String level) {
        this.level = level;
        return this;
    }

    public CursoBuilder hours(int hours) {
        this.hours = hours;
        return this;
    }

    public CursoBuilder syllabusUrl(String syllabusUrl) {
        this.syllabusUrl = syllabusUrl;
        return this;
    }

}