package co.edu.cesde.hrm.retention.infrastructure.persistence;

import co.edu.cesde.hrm.retention.application.port.output.EmpleadoConsultaPort;
import co.edu.cesde.hrm.retention.shared.dto.EmpleadoActivoDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class EmpleadoConsultaStubAdapter implements EmpleadoConsultaPort {

    private final List<EmpleadoActivoDTO> empleados = Arrays.asList(
            new EmpleadoActivoDTO(1L, "Juan Pérez"),
            new EmpleadoActivoDTO(2L, "María Rodríguez"),
            new EmpleadoActivoDTO(3L, "Carlos Gómez")
    );

    @Override
    public Optional<EmpleadoActivoDTO> findEmpleadoActivo(Long id) {
        return empleados.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public List<EmpleadoActivoDTO> findAllActivos() {
        return empleados;
    }
}
