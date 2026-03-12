package com.gestiontalentohumano.application.ports;

import com.gestiontalentohumano.domain.Aspirante;
import com.gestiontalentohumano.domain.Empleado;

/**
 * Puerto de entrada que define las operaciones ofrecidas por la aplicación.
 */
public interface InputPort {
    void registrarAspirante(Aspirante aspirante);
    void contratarAspirante(Aspirante aspirante);
    void generarNomina(Empleado empleado);
    // otros métodos según procesos
}
