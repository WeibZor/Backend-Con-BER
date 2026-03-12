package com.gestiontalentohumano.domain;

import java.time.LocalDate;

/**
 * Proceso de selección asociado a un aspirante.
 */
public class Seleccion {
    private String id;
    private Aspirante aspirante;
    private LocalDate fechaEvaluacion;
    private String estado; // e.g. "Aprobado", "Rechazado", "En espera"
    private String comentarios;

    public Seleccion() {}

    public Seleccion(String id, Aspirante aspirante, LocalDate fechaEvaluacion, String estado, String comentarios) {
        this.id = id;
        this.aspirante = aspirante;
        this.fechaEvaluacion = fechaEvaluacion;
        this.estado = estado;
        this.comentarios = comentarios;
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

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
