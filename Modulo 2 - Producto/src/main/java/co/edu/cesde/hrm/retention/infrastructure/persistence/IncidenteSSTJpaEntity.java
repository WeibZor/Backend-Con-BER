package co.edu.cesde.hrm.retention.infrastructure.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "incidentes_sst")
public class IncidenteSSTJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empleadoId;
    private String nombreEmpleado;
    private String tipo;
    private String descripcion;
    private LocalDate fecha;
    private int diasIncapacidad;
    private String estado;
    private String medidasCorrectivas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public int getDiasIncapacidad() { return diasIncapacidad; }
    public void setDiasIncapacidad(int diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMedidasCorrectivas() { return medidasCorrectivas; }
    public void setMedidasCorrectivas(String medidasCorrectivas) { this.medidasCorrectivas = medidasCorrectivas; }
}
