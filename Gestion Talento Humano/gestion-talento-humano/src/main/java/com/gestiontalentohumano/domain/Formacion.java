package com.gestiontalentohumano.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Registro de formación/desarrollo asociado a empleados.
 */
public class Formacion {
    private String id;
    private Empleado empleado;
    private String nombreCurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<String> competenciasAdquiridas;

    public Formacion() {}

    public Formacion(String id, Empleado empleado, String nombreCurso, LocalDate fechaInicio,
                     LocalDate fechaFin, List<String> competenciasAdquiridas) {
        this.id = id;
        this.empleado = empleado;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.competenciasAdquiridas = competenciasAdquiridas;
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

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<String> getCompetenciasAdquiridas() {
        return competenciasAdquiridas;
    }

    public void setCompetenciasAdquiridas(List<String> competenciasAdquiridas) {
        this.competenciasAdquiridas = competenciasAdquiridas;
    }
}
