package co.edu.cesde.hrm.retention.application.dto.command;

import co.edu.cesde.hrm.retention.domain.enums.TipoIncidente;

import java.time.LocalDate;

public class RegistrarIncidenteCommand {
    private Long empleadoId;
    private TipoIncidente tipo;
    private String descripcion;
    private LocalDate fecha;
    private Integer diasIncapacidad;

    public RegistrarIncidenteCommand() {}

    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
    public TipoIncidente getTipo() { return tipo; }
    public void setTipo(TipoIncidente tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Integer getDiasIncapacidad() { return diasIncapacidad; }
    public void setDiasIncapacidad(Integer diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
}
