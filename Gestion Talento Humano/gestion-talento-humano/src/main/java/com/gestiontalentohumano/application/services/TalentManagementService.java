package com.gestiontalentohumano.application.services;

import com.gestiontalentohumano.application.ports.InputPort;
import com.gestiontalentohumano.application.ports.OutputPort;
import com.gestiontalentohumano.domain.Aspirante;
import com.gestiontalentohumano.domain.Empleado;

/**
 * Servicio de aplicación que implementa el puerto de entrada y coordina la lógica de negocio.
 */
public class TalentManagementService implements InputPort {
    private final OutputPort output;

    public TalentManagementService(OutputPort output) {
        this.output = output;
    }

    @Override
    public void registrarAspirante(Aspirante aspirante) {
        // lógica de registro, validaciones, etc.
        output.guardarAspirante(aspirante);
    }

    @Override
    public void contratarAspirante(Aspirante aspirante) {
        // convertir aspirante a empleado y persistir
        Empleado empleado = new Empleado();
        // copiar datos mínimos...
        output.guardarEmpleado(empleado);
    }

    @Override
    public void generarNomina(Empleado empleado) {
        // calcular y delegar a salida
        output.guardarNomina(empleado);
    }
}
