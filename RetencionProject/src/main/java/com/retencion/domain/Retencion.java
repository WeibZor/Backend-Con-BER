package com.retencion.domain;

import java.time.LocalDate;

/**
 * Información de retención y seguridad y salud en el trabajo (SST).
 */
public class Retencion {
    private String id;
    private Empleado empleado;
    private LocalDate fechaRevision;
    private String riesgo;
    private String medidas;

    public Retencion() {}

    public Retencion(String id, Empleado empleado, LocalDate fechaRevision, String riesgo, String medidas) {
        this.id = id;
        this.empleado = empleado;
        this.fechaRevision = fechaRevision;
        this.riesgo = riesgo;
        this.medidas = medidas;
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

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }
}
