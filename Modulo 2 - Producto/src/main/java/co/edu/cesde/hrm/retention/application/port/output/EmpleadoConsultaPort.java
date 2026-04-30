package co.edu.cesde.hrm.retention.application.port.output;

import co.edu.cesde.hrm.retention.shared.dto.EmpleadoActivoDTO;

import java.util.List;
import java.util.Optional;

public interface EmpleadoConsultaPort {
    Optional<EmpleadoActivoDTO> findEmpleadoActivo(Long id);
    List<EmpleadoActivoDTO> findAllActivos();
}
