package com.gestiontalentohumano.domain;

import java.time.LocalDate;

/**
 * Registro de evaluación de desempeño de un empleado.
 */
public class EvaluacionDesempenio {
    private String id;
    private Empleado empleado;
    private LocalDate fechaEvaluacion;
    private int puntuacion;
    private String observaciones;

    public EvaluacionDesempenio() {}

    public EvaluacionDesempenio(String id, Empleado empleado, LocalDate fechaEvaluacion,
                                 int puntuacion, String observaciones) {
        this.id = id;
        this.empleado = empleado;
        this.fechaEvaluacion = fechaEvaluacion;
        this.puntuacion = puntuacion;
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
