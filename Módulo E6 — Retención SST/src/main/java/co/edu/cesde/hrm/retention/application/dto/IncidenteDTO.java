package co.edu.cesde.hrm.retention.application.dto;

import co.edu.cesde.hrm.retention.domain.enums.EstadoIncidente;
import co.edu.cesde.hrm.retention.domain.enums.TipoIncidente;

import java.time.LocalDate;

public class IncidenteDTO {
    private Long id;
    private Long empleadoId;
    private String nombreEmpleado;
    private TipoIncidente tipo;
    private String descripcion;
    private LocalDate fecha;
    private int diasIncapacidad;
    private EstadoIncidente estado;
    private String medidasCorrectivas;
    private String alerta;

    public IncidenteDTO() {}

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
    public void setDiasIncapacidad(int diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
    public EstadoIncidente getEstado() { return estado; }
    public void setEstado(EstadoIncidente estado) { this.estado = estado; }
    public String getMedidasCorrectivas() { return medidasCorrectivas; }
    public void setMedidasCorrectivas(String medidasCorrectivas) { this.medidasCorrectivas = medidasCorrectivas; }
    public String getAlerta() { return alerta; }
    public void setAlerta(String alerta) { this.alerta = alerta; }
}
