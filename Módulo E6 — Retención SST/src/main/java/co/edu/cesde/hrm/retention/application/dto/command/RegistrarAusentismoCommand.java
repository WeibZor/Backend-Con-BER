package co.edu.cesde.hrm.retention.application.dto.command;

import co.edu.cesde.hrm.retention.domain.enums.MotivoAusentismo;

import java.time.LocalDate;

public class RegistrarAusentismoCommand {
    private Long empleadoId;
    private MotivoAusentismo motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public RegistrarAusentismoCommand() {}

    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
    public MotivoAusentismo getMotivo() { return motivo; }
    public void setMotivo(MotivoAusentismo motivo) { this.motivo = motivo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
