package co.edu.cesde.hrm.retention.infrastructure.mapper;

import co.edu.cesde.hrm.retention.application.dto.AusentismoDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteDTO;
import co.edu.cesde.hrm.retention.application.dto.ProgramaDTO;
import co.edu.cesde.hrm.retention.domain.model.Ausentismo;
import co.edu.cesde.hrm.retention.domain.model.IncidenteSST;
import co.edu.cesde.hrm.retention.domain.model.ProgramaBienestar;
import co.edu.cesde.hrm.retention.infrastructure.persistence.AusentismoJpaEntity;
import co.edu.cesde.hrm.retention.infrastructure.persistence.IncidenteSSTJpaEntity;
import co.edu.cesde.hrm.retention.infrastructure.persistence.ProgramaBienestarJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SSTMapper {
    IncidenteSST toDomain(IncidenteSSTJpaEntity entity);
    IncidenteSSTJpaEntity toEntity(IncidenteSST domain);
    ProgramaBienestar toDomain(ProgramaBienestarJpaEntity entity);
    ProgramaBienestarJpaEntity toEntity(ProgramaBienestar domain);
    Ausentismo toDomain(AusentismoJpaEntity entity);
    AusentismoJpaEntity toEntity(Ausentismo domain);
    IncidenteDTO toDTO(IncidenteSST domain);
    ProgramaDTO toDTO(ProgramaBienestar domain);
    AusentismoDTO toDTO(Ausentismo domain);

    default String[] toCSVRow(IncidenteSST incidente) {
        return new String[] {
                incidente.getId() != null ? incidente.getId().toString() : "",
                incidente.getEmpleadoId() != null ? incidente.getEmpleadoId().toString() : "",
                incidente.getNombreEmpleado() != null ? incidente.getNombreEmpleado() : "",
                incidente.getTipo() != null ? incidente.getTipo() : "",
                incidente.getDescripcion() != null ? incidente.getDescripcion() : "",
                incidente.getFecha() != null ? incidente.getFecha().toString() : "",
                incidente.getEstado() != null ? incidente.getEstado() : "",
                String.valueOf(incidente.getDiasIncapacidad())
        };
    }
}
