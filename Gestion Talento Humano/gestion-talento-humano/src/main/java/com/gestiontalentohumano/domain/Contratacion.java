package com.gestiontalentohumano.domain;

import java.time.LocalDate;

/**
 * Representa la contratación de un aspirante que ha pasado por selección.
 */
public class Contratacion {
    private String id;
    private Aspirante aspirante;
    private Empleado empleado;
    private LocalDate fechaContrato;
    private String tipoContrato; // permanente, temporal, etc.

    public Contratacion() {}

    public Contratacion(String id, Aspirante aspirante, Empleado empleado,
                         LocalDate fechaContrato, String tipoContrato) {
        this.id = id;
        this.aspirante = aspirante;
        this.empleado = empleado;
        this.fechaContrato = fechaContrato;
        this.tipoContrato = tipoContrato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
