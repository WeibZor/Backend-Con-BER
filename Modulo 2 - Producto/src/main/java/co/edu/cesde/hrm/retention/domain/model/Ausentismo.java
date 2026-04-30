package co.edu.cesde.hrm.retention.domain.model;

import co.edu.cesde.hrm.retention.domain.enums.MotivoAusentismo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ausentismo {
    private Long id;
    private Long empleadoId;
    private MotivoAusentismo motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Ausentismo() {}

    public Ausentismo(Long empleadoId, MotivoAusentismo motivo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.empleadoId = empleadoId;
        this.motivo = motivo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long getDiasTotales() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;
    }

    public boolean esPorIncidente() {
        return motivo == MotivoAusentismo.ACCIDENTE_TRABAJO || motivo == MotivoAusentismo.INCAPACIDAD_MEDICA;
    }

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
}
