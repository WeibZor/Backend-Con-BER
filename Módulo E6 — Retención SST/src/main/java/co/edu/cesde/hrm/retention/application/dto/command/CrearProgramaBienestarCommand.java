package co.edu.cesde.hrm.retention.application.dto.command;

import co.edu.cesde.hrm.retention.domain.enums.TipoBienestar;

import java.time.LocalDate;

public class CrearProgramaBienestarCommand {
    private String nombre;
    private TipoBienestar tipo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String responsable;

    public CrearProgramaBienestarCommand() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public TipoBienestar getTipo() { return tipo; }
    public void setTipo(TipoBienestar tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
