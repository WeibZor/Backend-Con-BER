package co.edu.cesde.hrm.retention.infrastructure.persistence;

import co.edu.cesde.hrm.retention.application.port.output.SSTPersistencePort;
import co.edu.cesde.hrm.retention.domain.model.Ausentismo;
import co.edu.cesde.hrm.retention.domain.model.IncidenteSST;
import co.edu.cesde.hrm.retention.domain.model.ProgramaBienestar;
import co.edu.cesde.hrm.retention.infrastructure.mapper.SSTMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SSTPersistenceAdapter implements SSTPersistencePort {

    private final IncidenteSSTJpaRepository incidenteRepository;
    private final ProgramaBienestarJpaRepository programaRepository;
    private final AusentismoJpaRepository ausentismoRepository;
    private final SSTMapper mapper;

    public SSTPersistenceAdapter(IncidenteSSTJpaRepository incidenteRepository,
                                 ProgramaBienestarJpaRepository programaRepository,
                                 AusentismoJpaRepository ausentismoRepository,
                                 SSTMapper mapper) {
        this.incidenteRepository = incidenteRepository;
        this.programaRepository = programaRepository;
        this.ausentismoRepository = ausentismoRepository;
        this.mapper = mapper;
    }

    @Override
    public IncidenteSST saveIncidente(IncidenteSST incidente) {
        return mapper.toDomain(incidenteRepository.save(mapper.toEntity(incidente)));
    }

    @Override
    public ProgramaBienestar savePrograma(ProgramaBienestar programa) {
        return mapper.toDomain(programaRepository.save(mapper.toEntity(programa)));
    }

    @Override
    public Ausentismo saveAusentismo(Ausentismo ausentismo) {
        return mapper.toDomain(ausentismoRepository.save(mapper.toEntity(ausentismo)));
    }

    @Override
    public Optional<IncidenteSST> findIncidenteById(Long id) {
        return incidenteRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<IncidenteSST> findByEmpleadoId(Long empleadoId) {
        return incidenteRepository.findByEmpleadoId(empleadoId).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<IncidenteSST> findIncidentesByTipo(String tipo) {
        return incidenteRepository.findByTipo(tipo).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<IncidenteSST> findAll() {
        return incidenteRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Ausentismo> findAusentismosByEmpleadoId(Long empleadoId) {
        return ausentismoRepository.findByEmpleadoId(empleadoId).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Ausentismo> findAllAusentismos() {
        return ausentismoRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<ProgramaBienestar> findProgramaByNombre(String nombre) {
        return programaRepository.findByNombre(nombre).map(mapper::toDomain);
    }

    @Override
    public List<ProgramaBienestar> findAllProgramas() {
        return programaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
