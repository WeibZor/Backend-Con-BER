package com.gestiontalentohumano.domain;

import java.time.LocalDate;

/**
 * Representa a una persona que se postula para un puesto.
 */
public class Aspirante extends Persona {
    private String puestoDeseado;
    private LocalDate fechaRegistro;

    public Aspirante() {
        super();
    }

    public Aspirante(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                     String puestoDeseado, LocalDate fechaRegistro) {
        super(id, nombre, apellido, fechaNacimiento);
        this.puestoDeseado = puestoDeseado;
        this.fechaRegistro = fechaRegistro;
    }

    public String getPuestoDeseado() {
        return puestoDeseado;
    }

    public void setPuestoDeseado(String puestoDeseado) {
        this.puestoDeseado = puestoDeseado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
