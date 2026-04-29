package co.edu.cesde.hrm.retention.application.dto.command;

public class CerrarIncidenteCommand {
    private String medidasCorrectivas;
    private Integer diasIncapacidad;

    public CerrarIncidenteCommand() {}

    public String getMedidasCorrectivas() { return medidasCorrectivas; }
    public void setMedidasCorrectivas(String medidasCorrectivas) { this.medidasCorrectivas = medidasCorrectivas; }
    public Integer getDiasIncapacidad() { return diasIncapacidad; }
    public void setDiasIncapacidad(Integer diasIncapacidad) { this.diasIncapacidad = diasIncapacidad; }
}
