package co.edu.cesde.hrm.retention.domain.model;

import co.edu.cesde.hrm.retention.domain.enums.TipoBienestar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProgramaBienestar {
    private Long id;
    private String nombre;
    private TipoBienestar tipo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activo;
    private String responsable;

    public ProgramaBienestar() {
        this.activo = true;
    }

    public ProgramaBienestar(String nombre, TipoBienestar tipo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String responsable) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.responsable = responsable;
        this.activo = true;
    }

    public void activar() {
        this.activo = true;
    }

    public void cerrar() {
        this.activo = false;
    }

    public boolean estaVigente() {
        LocalDate now = LocalDate.now();
        return activo && !fechaInicio.isAfter(now) && !fechaFin.isBefore(now);
    }

    public long getDuracionDias() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
