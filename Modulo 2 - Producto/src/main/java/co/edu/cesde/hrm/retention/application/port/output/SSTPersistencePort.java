package co.edu.cesde.hrm.retention.application.port.output;

import co.edu.cesde.hrm.retention.domain.model.Ausentismo;
import co.edu.cesde.hrm.retention.domain.model.IncidenteSST;
import co.edu.cesde.hrm.retention.domain.model.ProgramaBienestar;

import java.util.List;
import java.util.Optional;

public interface SSTPersistencePort {
    IncidenteSST saveIncidente(IncidenteSST incidente);
    ProgramaBienestar savePrograma(ProgramaBienestar programa);
    Ausentismo saveAusentismo(Ausentismo ausentismo);
    Optional<IncidenteSST> findIncidenteById(Long id);
    List<IncidenteSST> findByEmpleadoId(Long empleadoId);
    List<IncidenteSST> findIncidentesByTipo(String tipo);
    List<IncidenteSST> findAll();
    List<Ausentismo> findAusentismosByEmpleadoId(Long empleadoId);
    List<Ausentismo> findAllAusentismos();
    Optional<ProgramaBienestar> findProgramaByNombre(String nombre);
    List<ProgramaBienestar> findAllProgramas();
}
