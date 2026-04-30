package co.edu.cesde.hrm.retention.infrastructure.mapper;

import co.edu.cesde.hrm.retention.application.dto.AusentismoDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteDTO;
import co.edu.cesde.hrm.retention.application.dto.ProgramaDTO;
import co.edu.cesde.hrm.retention.domain.enums.EstadoIncidente;
import co.edu.cesde.hrm.retention.domain.enums.MotivoAusentismo;
import co.edu.cesde.hrm.retention.domain.enums.TipoBienestar;
import co.edu.cesde.hrm.retention.domain.enums.TipoIncidente;
import co.edu.cesde.hrm.retention.domain.model.Ausentismo;
import co.edu.cesde.hrm.retention.domain.model.IncidenteSST;
import co.edu.cesde.hrm.retention.domain.model.ProgramaBienestar;
import co.edu.cesde.hrm.retention.infrastructure.persistence.AusentismoJpaEntity;
import co.edu.cesde.hrm.retention.infrastructure.persistence.IncidenteSSTJpaEntity;
import co.edu.cesde.hrm.retention.infrastructure.persistence.ProgramaBienestarJpaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-29T19:17:40-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SSTMapperImpl implements SSTMapper {

    @Override
    public IncidenteSST toDomain(IncidenteSSTJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        IncidenteSST incidenteSST = new IncidenteSST();

        incidenteSST.setId( entity.getId() );
        incidenteSST.setEmpleadoId( entity.getEmpleadoId() );
        incidenteSST.setNombreEmpleado( entity.getNombreEmpleado() );
        if ( entity.getTipo() != null ) {
            incidenteSST.setTipo( Enum.valueOf( TipoIncidente.class, entity.getTipo() ) );
        }
        incidenteSST.setDescripcion( entity.getDescripcion() );
        incidenteSST.setFecha( entity.getFecha() );
        incidenteSST.setDiasIncapacidad( entity.getDiasIncapacidad() );
        if ( entity.getEstado() != null ) {
            incidenteSST.setEstado( Enum.valueOf( EstadoIncidente.class, entity.getEstado() ) );
        }
        incidenteSST.setMedidasCorrectivas( entity.getMedidasCorrectivas() );

        return incidenteSST;
    }

    @Override
    public IncidenteSSTJpaEntity toEntity(IncidenteSST domain) {
        if ( domain == null ) {
            return null;
        }

        IncidenteSSTJpaEntity incidenteSSTJpaEntity = new IncidenteSSTJpaEntity();

        incidenteSSTJpaEntity.setId( domain.getId() );
        incidenteSSTJpaEntity.setEmpleadoId( domain.getEmpleadoId() );
        incidenteSSTJpaEntity.setNombreEmpleado( domain.getNombreEmpleado() );
        if ( domain.getTipo() != null ) {
            incidenteSSTJpaEntity.setTipo( domain.getTipo().name() );
        }
        incidenteSSTJpaEntity.setDescripcion( domain.getDescripcion() );
        incidenteSSTJpaEntity.setFecha( domain.getFecha() );
        incidenteSSTJpaEntity.setDiasIncapacidad( domain.getDiasIncapacidad() );
        if ( domain.getEstado() != null ) {
            incidenteSSTJpaEntity.setEstado( domain.getEstado().name() );
        }
        incidenteSSTJpaEntity.setMedidasCorrectivas( domain.getMedidasCorrectivas() );

        return incidenteSSTJpaEntity;
    }

    @Override
    public ProgramaBienestar toDomain(ProgramaBienestarJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProgramaBienestar programaBienestar = new ProgramaBienestar();

        programaBienestar.setId( entity.getId() );
        programaBienestar.setNombre( entity.getNombre() );
        if ( entity.getTipo() != null ) {
            programaBienestar.setTipo( Enum.valueOf( TipoBienestar.class, entity.getTipo() ) );
        }
        programaBienestar.setDescripcion( entity.getDescripcion() );
        programaBienestar.setFechaInicio( entity.getFechaInicio() );
        programaBienestar.setFechaFin( entity.getFechaFin() );
        programaBienestar.setActivo( entity.isActivo() );
        programaBienestar.setResponsable( entity.getResponsable() );

        return programaBienestar;
    }

    @Override
    public ProgramaBienestarJpaEntity toEntity(ProgramaBienestar domain) {
        if ( domain == null ) {
            return null;
        }

        ProgramaBienestarJpaEntity programaBienestarJpaEntity = new ProgramaBienestarJpaEntity();

        programaBienestarJpaEntity.setId( domain.getId() );
        programaBienestarJpaEntity.setNombre( domain.getNombre() );
        if ( domain.getTipo() != null ) {
            programaBienestarJpaEntity.setTipo( domain.getTipo().name() );
        }
        programaBienestarJpaEntity.setDescripcion( domain.getDescripcion() );
        programaBienestarJpaEntity.setFechaInicio( domain.getFechaInicio() );
        programaBienestarJpaEntity.setFechaFin( domain.getFechaFin() );
        programaBienestarJpaEntity.setActivo( domain.isActivo() );
        programaBienestarJpaEntity.setResponsable( domain.getResponsable() );

        return programaBienestarJpaEntity;
    }

    @Override
    public Ausentismo toDomain(AusentismoJpaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Ausentismo ausentismo = new Ausentismo();

        ausentismo.setId( entity.getId() );
        ausentismo.setEmpleadoId( entity.getEmpleadoId() );
        if ( entity.getMotivo() != null ) {
            ausentismo.setMotivo( Enum.valueOf( MotivoAusentismo.class, entity.getMotivo() ) );
        }
        ausentismo.setFechaInicio( entity.getFechaInicio() );
        ausentismo.setFechaFin( entity.getFechaFin() );

        return ausentismo;
    }

    @Override
    public AusentismoJpaEntity toEntity(Ausentismo domain) {
        if ( domain == null ) {
            return null;
        }

        AusentismoJpaEntity ausentismoJpaEntity = new AusentismoJpaEntity();

        ausentismoJpaEntity.setId( domain.getId() );
        ausentismoJpaEntity.setEmpleadoId( domain.getEmpleadoId() );
        if ( domain.getMotivo() != null ) {
            ausentismoJpaEntity.setMotivo( domain.getMotivo().name() );
        }
        ausentismoJpaEntity.setFechaInicio( domain.getFechaInicio() );
        ausentismoJpaEntity.setFechaFin( domain.getFechaFin() );

        return ausentismoJpaEntity;
    }

    @Override
    public IncidenteDTO toDTO(IncidenteSST domain) {
        if ( domain == null ) {
            return null;
        }

        IncidenteDTO incidenteDTO = new IncidenteDTO();

        incidenteDTO.setId( domain.getId() );
        incidenteDTO.setEmpleadoId( domain.getEmpleadoId() );
        incidenteDTO.setNombreEmpleado( domain.getNombreEmpleado() );
        incidenteDTO.setTipo( domain.getTipo() );
        incidenteDTO.setDescripcion( domain.getDescripcion() );
        incidenteDTO.setFecha( domain.getFecha() );
        incidenteDTO.setDiasIncapacidad( domain.getDiasIncapacidad() );
        incidenteDTO.setEstado( domain.getEstado() );
        incidenteDTO.setMedidasCorrectivas( domain.getMedidasCorrectivas() );

        return incidenteDTO;
    }

    @Override
    public ProgramaDTO toDTO(ProgramaBienestar domain) {
        if ( domain == null ) {
            return null;
        }

        ProgramaDTO programaDTO = new ProgramaDTO();

        programaDTO.setId( domain.getId() );
        programaDTO.setNombre( domain.getNombre() );
        programaDTO.setTipo( domain.getTipo() );
        programaDTO.setDescripcion( domain.getDescripcion() );
        programaDTO.setFechaInicio( domain.getFechaInicio() );
        programaDTO.setFechaFin( domain.getFechaFin() );
        programaDTO.setActivo( domain.isActivo() );
        programaDTO.setResponsable( domain.getResponsable() );

        return programaDTO;
    }

    @Override
    public AusentismoDTO toDTO(Ausentismo domain) {
        if ( domain == null ) {
            return null;
        }

        AusentismoDTO ausentismoDTO = new AusentismoDTO();

        ausentismoDTO.setId( domain.getId() );
        ausentismoDTO.setEmpleadoId( domain.getEmpleadoId() );
        ausentismoDTO.setMotivo( domain.getMotivo() );
        ausentismoDTO.setFechaInicio( domain.getFechaInicio() );
        ausentismoDTO.setFechaFin( domain.getFechaFin() );
        ausentismoDTO.setDiasTotales( domain.getDiasTotales() );

        return ausentismoDTO;
    }
}
