package com.retencion.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Representa a un empleado dentro del proceso de retención.
 */
public class Empleado extends Persona {
    private String cargo;
    private LocalDate fechaIngreso;
    private List<String> habilidades;

    public Empleado() {
        super();
    }

    public Empleado(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                    String cargo, LocalDate fechaIngreso, List<String> habilidades) {
        super(id, nombre, apellido, fechaNacimiento);
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.habilidades = habilidades;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
