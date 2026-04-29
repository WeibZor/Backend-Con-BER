package co.edu.cesde.hrm.retention.application.dto;

public class IncidenteCierreDTO {
    private IncidenteDTO incidente;
    private Long ausentismoId;

    public IncidenteCierreDTO() {}

    public IncidenteDTO getIncidente() { return incidente; }
    public void setIncidente(IncidenteDTO incidente) { this.incidente = incidente; }
    public Long getAusentismoId() { return ausentismoId; }
    public void setAusentismoId(Long ausentismoId) { this.ausentismoId = ausentismoId; }
}
