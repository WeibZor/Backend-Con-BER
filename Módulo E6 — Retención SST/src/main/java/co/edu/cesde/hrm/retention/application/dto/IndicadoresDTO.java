package co.edu.cesde.hrm.retention.application.dto;

import java.util.Map;

public class IndicadoresDTO {
    private Integer periodo;
    private Long totalIncidentes;
    private Map<String, Long> totalPorTipo;
    private Double tasaAccidentalidad;
    private Double tasaAusentismo;
    private Long totalDiasAusentismo;

    public IndicadoresDTO() {}

    public Integer getPeriodo() { return periodo; }
    public void setPeriodo(Integer periodo) { this.periodo = periodo; }
    public Long getTotalIncidentes() { return totalIncidentes; }
    public void setTotalIncidentes(Long totalIncidentes) { this.totalIncidentes = totalIncidentes; }
    public Map<String, Long> getTotalPorTipo() { return totalPorTipo; }
    public void setTotalPorTipo(Map<String, Long> totalPorTipo) { this.totalPorTipo = totalPorTipo; }
    public Double getTasaAccidentalidad() { return tasaAccidentalidad; }
    public void setTasaAccidentalidad(Double tasaAccidentalidad) { this.tasaAccidentalidad = tasaAccidentalidad; }
    public Double getTasaAusentismo() { return tasaAusentismo; }
    public void setTasaAusentismo(Double tasaAusentismo) { this.tasaAusentismo = tasaAusentismo; }
    public Long getTotalDiasAusentismo() { return totalDiasAusentismo; }
    public void setTotalDiasAusentismo(Long totalDiasAusentismo) { this.totalDiasAusentismo = totalDiasAusentismo; }
}
