package co.edu.cesde.hrm.retention.domain.model;

import co.edu.cesde.hrm.retention.domain.enums.EstadoIncidente;
import co.edu.cesde.hrm.retention.domain.enums.TipoIncidente;

import java.time.LocalDate;

public class IncidenteSST {
    private Long id;
    private Long empleadoId;
    private String nombreEmpleado;
    private TipoIncidente tipo;
    private String descripcion;
    private LocalDate fecha;
    private int diasIncapacidad;
    private EstadoIncidente estado;
    private String medidasCorrectivas;

    public IncidenteSST() {
        this.estado = EstadoIncidente.REPORTADO;
        this.diasIncapacidad = 0;
    }

    public IncidenteSST(Long empleadoId, String nombreEmpleado, TipoIncidente tipo, String descripcion, LocalDate fecha) {
        this.empleadoId = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = EstadoIncidente.REPORTADO;
        this.diasIncapacidad = 0;
    }

    public void investigar() {
        if (this.estado != EstadoIncidente.REPORTADO) {
            throw new IllegalStateException("Solo los incidentes reportados pueden ser investigados.");
        }
        this.estado = EstadoIncidente.EN_INVESTIGACION;
    }

    public void cerrar(String medidas) {
        if (this.estado != EstadoIncidente.EN_INVESTIGACION) {
            throw new IllegalStateException("Solo los incidentes en investigación pueden cerrarse.");
        }
        if (medidas == null || medidas.isBlank()) {
            throw new IllegalArgumentException("Las medidas correctivas son obligatorias para el cierre.");
        }
        this.estado = EstadoIncidente.CERRADO;
        this.medidasCorrectivas = medidas;
    }

    public boolean esCritico() {
        return this.tipo == TipoIncidente.ACCIDENTE_TRABAJO || this.diasIncapacidad > 15;
    }

    public String generarAlerta() {
        return esCritico() ? "Incidente crítico detectado" : null;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public TipoIncidente getTipo() { return tipo; }
    public void setTipo(TipoIncidente tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public int getDiasIncapacidad() { return diasIncapacidad; }
    public void setDiasIncapacidad(int diasIncapacidad) {
        if (diasIncapacidad < 0) {
            throw new IllegalArgumentException("Los días de incapacidad no pueden ser negativos.");
        }
        this.diasIncapacidad = diasIncapacidad;
    }
    public EstadoIncidente getEstado() { return estado; }
    public void setEstado(EstadoIncidente estado) { this.estado = estado; }
    public String getMedidasCorrectivas() { return medidasCorrectivas; }
    public void setMedidasCorrectivas(String medidasCorrectivas) { this.medidasCorrectivas = medidasCorrectivas; }
}
