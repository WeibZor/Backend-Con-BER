package co.edu.cesde.hrm.retention.shared.dto;

public class EmpleadoActivoDTO {
    private Long id;
    private String nombre;

    public EmpleadoActivoDTO() {}

    public EmpleadoActivoDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
