package com.retencion.domain;

import java.time.LocalDate;

/**
 * Entidad base para personas en el dominio de retención.
 */
public abstract class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona() {}

    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
