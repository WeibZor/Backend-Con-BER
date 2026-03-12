package com.gestiontalentohumano.infrastructure.adapters;

import com.gestiontalentohumano.application.ports.OutputPort;
import com.gestiontalentohumano.domain.Aspirante;
import com.gestiontalentohumano.domain.Empleado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador simple en memoria usado para pruebas o prototipo.
 */
@Repository
public class InMemoryRepository implements OutputPort {
    private final List<Aspirante> aspirantes = new ArrayList<>();
    private final List<Empleado> empleados = new ArrayList<>();

    @Override
    public void guardarAspirante(Aspirante aspirante) {
        aspirantes.add(aspirante);
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public void guardarNomina(Empleado empleado) {
        // en un repositorio real se guardaría la nómina asociada
    }

    // métodos adicionales para obtener información
    public List<Aspirante> obtenerAspirantes() {
        return aspirantes;
    }

    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }
}
