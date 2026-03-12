package com.gestiontalentohumano.application.ports;

import com.gestiontalentohumano.domain.Aspirante;
import com.gestiontalentohumano.domain.Empleado;

/**
 * Puerto de salida utilizado por la aplicación para comunicarse con infraestructura.
 */
public interface OutputPort {
    void guardarAspirante(Aspirante aspirante);
    void guardarEmpleado(Empleado empleado);
    void guardarNomina(Empleado empleado);
    // otros métodos de persistencia o servicios externos
}
