package com.gestiontalentohumano.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa un registro de nómina para un empleado.
 */
public class Nomina {
    private String id;
    private Empleado empleado;
    private LocalDate periodoInicio;
    private LocalDate periodoFin;
    private BigDecimal salarioBruto;
    private BigDecimal deducciones;
    private BigDecimal salarioNeto;

    public Nomina() {}

    public Nomina(String id, Empleado empleado, LocalDate periodoInicio, LocalDate periodoFin,
                  BigDecimal salarioBruto, BigDecimal deducciones, BigDecimal salarioNeto) {
        this.id = id;
        this.empleado = empleado;
        this.periodoInicio = periodoInicio;
        this.periodoFin = periodoFin;
        this.salarioBruto = salarioBruto;
        this.deducciones = deducciones;
        this.salarioNeto = salarioNeto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDate getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(LocalDate periodoFin) {
        this.periodoFin = periodoFin;
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public BigDecimal getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(BigDecimal deducciones) {
        this.deducciones = deducciones;
    }

    public BigDecimal getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(BigDecimal salarioNeto) {
        this.salarioNeto = salarioNeto;
    }
}
