package co.edu.cesde.hrm.retention.application.dto;

import co.edu.cesde.hrm.retention.domain.enums.MotivoAusentismo;

import java.time.LocalDate;

public class AusentismoDTO {
    private Long id;
    private Long empleadoId;
    private MotivoAusentismo motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private long diasTotales;
    private boolean esPorIncidente;

    public AusentismoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
    public MotivoAusentismo getMotivo() { return motivo; }
    public void setMotivo(MotivoAusentismo motivo) { this.motivo = motivo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public long getDiasTotales() { return diasTotales; }
    public void setDiasTotales(long diasTotales) { this.diasTotales = diasTotales; }
    public boolean isEsPorIncidente() { return esPorIncidente; }
    public void setEsPorIncidente(boolean esPorIncidente) { this.esPorIncidente = esPorIncidente; }
}
