package co.edu.cesde.hrm.retention.application.usecase;

import co.edu.cesde.hrm.retention.application.dto.AusentismoDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteCierreDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteDTO;
import co.edu.cesde.hrm.retention.application.dto.IndicadoresDTO;
import co.edu.cesde.hrm.retention.application.dto.ProgramaDTO;
import co.edu.cesde.hrm.retention.application.dto.command.CerrarIncidenteCommand;
import co.edu.cesde.hrm.retention.application.dto.command.CrearProgramaBienestarCommand;
import co.edu.cesde.hrm.retention.application.dto.command.RegistrarAusentismoCommand;
import co.edu.cesde.hrm.retention.application.dto.command.RegistrarIncidenteCommand;
import co.edu.cesde.hrm.retention.application.port.input.SSTServicePort;
import co.edu.cesde.hrm.retention.application.port.output.EmpleadoConsultaPort;
import co.edu.cesde.hrm.retention.application.port.output.SSTPersistencePort;
import co.edu.cesde.hrm.retention.domain.enums.MotivoAusentismo;
import co.edu.cesde.hrm.retention.domain.model.Ausentismo;
import co.edu.cesde.hrm.retention.domain.model.IncidenteSST;
import co.edu.cesde.hrm.retention.domain.model.ProgramaBienestar;
import co.edu.cesde.hrm.retention.shared.dto.EmpleadoActivoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SSTUseCase implements SSTServicePort {

    private final SSTPersistencePort persistencePort;
    private final EmpleadoConsultaPort empleadoConsultaPort;

    public SSTUseCase(SSTPersistencePort persistencePort, EmpleadoConsultaPort empleadoConsultaPort) {
        this.persistencePort = persistencePort;
        this.empleadoConsultaPort = empleadoConsultaPort;
    }

    @Override
    public IncidenteDTO registrarIncidente(RegistrarIncidenteCommand command) {
        validateRegistrarIncidente(command);
        EmpleadoActivoDTO empleado = empleadoConsultaPort.findEmpleadoActivo(command.getEmpleadoId())
                .orElseThrow(() -> new IllegalArgumentException("Empleado no existe o no está activo."));
        IncidenteSST incidente = new IncidenteSST(empleado.getId(), empleado.getNombre(), command.getTipo(), command.getDescripcion(), command.getFecha());
        if (command.getDiasIncapacidad() != null) {
            incidente.setDiasIncapacidad(command.getDiasIncapacidad());
        }
        IncidenteSST saved = persistencePort.saveIncidente(incidente);
        IncidenteDTO dto = toDto(saved);
        if (saved.esCritico()) {
            dto.setAlerta(saved.generarAlerta());
        }
        return dto;
    }

    @Override
    public void investigarIncidente(Long id) {
        IncidenteSST incidente = persistencePort.findIncidenteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente no encontrado."));
        incidente.investigar();
        persistencePort.saveIncidente(incidente);
    }

    @Override
    public IncidenteCierreDTO cerrarIncidente(Long id, CerrarIncidenteCommand command) {
        if (command.getMedidasCorrectivas() == null || command.getMedidasCorrectivas().isBlank()) {
            throw new IllegalArgumentException("Las medidas correctivas son obligatorias.");
        }
        IncidenteSST incidente = persistencePort.findIncidenteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente no encontrado."));
        if (command.getDiasIncapacidad() != null) {
            incidente.setDiasIncapacidad(command.getDiasIncapacidad());
        }
        incidente.cerrar(command.getMedidasCorrectivas());
        persistencePort.saveIncidente(incidente);
        IncidenteCierreDTO cierreDTO = new IncidenteCierreDTO();
        cierreDTO.setIncidente(toDto(incidente));
        if (incidente.getDiasIncapacidad() > 0) {
            Ausentismo ausentismo = new Ausentismo(incidente.getEmpleadoId(), motivoPorTipoIncidente(incidente), incidente.getFecha(), incidente.getFecha().plusDays(incidente.getDiasIncapacidad() - 1));
            Ausentismo saved = persistencePort.saveAusentismo(ausentismo);
            cierreDTO.setAusentismoId(saved.getId());
        }
        return cierreDTO;
    }

    @Override
    public ProgramaDTO crearProgramaBienestar(CrearProgramaBienestarCommand command) {
        validateCrearPrograma(command);
        persistencePort.findProgramaByNombre(command.getNombre()).ifPresent(p -> {
            throw new IllegalArgumentException("Ya existe un programa con ese nombre.");
        });
        ProgramaBienestar programa = new ProgramaBienestar(command.getNombre(), command.getTipo(), command.getDescripcion(), command.getFechaInicio(), command.getFechaFin(), command.getResponsable());
        ProgramaBienestar saved = persistencePort.savePrograma(programa);
        return toDto(saved);
    }

    @Override
    public AusentismoDTO registrarAusentismo(RegistrarAusentismoCommand command) {
        validateRegistrarAusentismo(command);
        List<Ausentismo> existentes = persistencePort.findAusentismosByEmpleadoId(command.getEmpleadoId());
        if (existenSolapamientos(existentes, command.getFechaInicio(), command.getFechaFin())) {
            throw new IllegalArgumentException("El empleado ya tiene un ausentismo solapado en ese periodo.");
        }
        Ausentismo ausentismo = new Ausentismo(command.getEmpleadoId(), command.getMotivo(), command.getFechaInicio(), command.getFechaFin());
        Ausentismo saved = persistencePort.saveAusentismo(ausentismo);
        return toDto(saved);
    }

    @Override
    public IndicadoresDTO indicadoresPorEmpleado(Long id, Integer periodo) {
        EmpleadoActivoDTO empleado = empleadoConsultaPort.findEmpleadoActivo(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no existe o no está activo."));
        List<IncidenteSST> incidentes = persistencePort.findByEmpleadoId(id).stream()
                .filter(i -> filtrarPorPeriodo(i.getFecha(), periodo))
                .collect(Collectors.toList());
        List<Ausentismo> ausentismos = persistencePort.findAusentismosByEmpleadoId(id).stream()
                .filter(a -> filtrarPorPeriodo(a.getFechaInicio(), periodo) || filtrarPorPeriodo(a.getFechaFin(), periodo))
                .collect(Collectors.toList());
        IndicadoresDTO dto = new IndicadoresDTO();
        dto.setPeriodo(periodo);
        dto.setTotalIncidentes((long) incidentes.size());
        dto.setTotalPorTipo(totalIncidentesPorTipo(incidentes));
        long diasPerdidos = ausentismos.stream().mapToLong(Ausentismo::getDiasTotales).sum();
        dto.setTotalDiasAusentismo(diasPerdidos);
        List<EmpleadoActivoDTO> empleados = empleadoConsultaPort.findAllActivos();
        dto.setTasaAccidentalidad(calcularTasaAccidentalidad(incidentes.size(), empleados.size()));
        dto.setTasaAusentismo(calcularTasaAusentismo(diasPerdidos, 240L));
        return dto;
    }

    @Override
    public IndicadoresDTO indicadoresGlobales(Integer periodo) {
        List<IncidenteSST> incidentes = persistencePort.findAll().stream()
                .filter(i -> filtrarPorPeriodo(i.getFecha(), periodo))
                .collect(Collectors.toList());
        List<Ausentismo> ausentismos = persistencePort.findAllAusentismos().stream()
                .filter(a -> filtrarPorPeriodo(a.getFechaInicio(), periodo) || filtrarPorPeriodo(a.getFechaFin(), periodo))
                .collect(Collectors.toList());
        List<EmpleadoActivoDTO> empleados = empleadoConsultaPort.findAllActivos();
        IndicadoresDTO dto = new IndicadoresDTO();
        dto.setPeriodo(periodo);
        dto.setTotalIncidentes((long) incidentes.size());
        dto.setTotalPorTipo(totalIncidentesPorTipo(incidentes));
        long diasPerdidos = ausentismos.stream().mapToLong(Ausentismo::getDiasTotales).sum();
        dto.setTotalDiasAusentismo(diasPerdidos);
        dto.setTasaAccidentalidad(calcularTasaAccidentalidad(incidentes.size(), empleados.size()));
        dto.setTasaAusentismo(calcularTasaAusentismo(diasPerdidos, (long) empleados.size() * 240L));
        return dto;
    }

    @Override
    public IncidenteDTO buscarIncidentePorId(Long id) {
        IncidenteSST incidente = persistencePort.findIncidenteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incidente no encontrado."));
        return toDto(incidente);
    }

    @Override
    public byte[] exportarCSV(String tipo, String estado) {
        List<IncidenteSST> incidentes = persistencePort.findAllIncidents();
        if (tipo != null && !tipo.isBlank()) {
            incidentes = incidentes.stream()
                    .filter(i -> i.getTipo().name().equalsIgnoreCase(tipo))
                    .collect(Collectors.toList());
        }
        if (estado != null && !estado.isBlank()) {
            incidentes = incidentes.stream()
                    .filter(i -> i.getEstado().name().equalsIgnoreCase(estado))
                    .collect(Collectors.toList());
        }
        List<Ausentismo> ausentismos = persistencePort.findAllAusentismos();
        StringBuilder csv = new StringBuilder();
        csv.append("incidente_id,empleado_id,nombre_empleado,tipo_incidente,fecha,dias_incapacidad,estado,es_critico,medidas_correctivas,ausentismo_id,motivo_ausentismo,dias_ausentismo\n");
        for (IncidenteSST incidente : incidentes) {
            Optional<Ausentismo> maybeAusentismo = ausentismos.stream()
                    .filter(a -> a.getEmpleadoId().equals(incidente.getEmpleadoId()) && fechainicioOfechaFinCorresponde(a, incidente))
                    .findFirst();
            csv.append(incidente.getId()).append(',');
            csv.append(incidente.getEmpleadoId()).append(',');
            csv.append(escape(incidente.getNombreEmpleado())).append(',');
            csv.append(incidente.getTipo().name()).append(',');
            csv.append(incidente.getFecha()).append(',');
            csv.append(incidente.getDiasIncapacidad()).append(',');
            csv.append(incidente.getEstado().name()).append(',');
            csv.append(incidente.esCritico()).append(',');
            csv.append(escape(incidente.getMedidasCorrectivas())).append(',');
            if (maybeAusentismo.isPresent()) {
                Ausentismo ausentismo = maybeAusentismo.get();
                csv.append(ausentismo.getId()).append(',');
                csv.append(ausentismo.getMotivo().name()).append(',');
                csv.append(ausentismo.getDiasTotales());
            } else {
                csv.append(",,");
            }
            csv.append('\n');
        }
        return csv.toString().getBytes();
    }

    @Override
    public List<ProgramaDTO> listarProgramas() {
        return persistencePort.findAllProgramas().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProgramaDTO> listarProgramasActivos() {
        return persistencePort.findAllProgramas().stream()
                .filter(ProgramaBienestar::estaVigente)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AusentismoDTO> historialAusentismoPorEmpleado(Long empleadoId) {
        return persistencePort.findAusentismosByEmpleadoId(empleadoId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private boolean filtrarPorPeriodo(LocalDate fecha, Integer periodo) {
        return periodo == null || fecha.getYear() == periodo;
    }

    private boolean fechainicioOfechaFinCorresponde(Ausentismo ausentismo, IncidenteSST incidente) {
        return !ausentismo.getFechaInicio().isAfter(incidente.getFecha().plusDays(incidente.getDiasIncapacidad()))
                && !ausentismo.getFechaFin().isBefore(incidente.getFecha());
    }

    private Double calcularTasaAusentismo(long diasPerdidos, long diasEsperados) {
        if (diasEsperados == 0) {
            return 0.0;
        }
        return Math.round((double) diasPerdidos / diasEsperados * 100.0 * 100.0) / 100.0;
    }

    private double calcularTasaAccidentalidad(long incidentes, long empleadosActivos) {
        if (empleadosActivos == 0) {
            return 0.0;
        }
        return Math.round((double) incidentes / empleadosActivos * 100.0 * 100.0) / 100.0;
    }

    private Map<String, Long> totalIncidentesPorTipo(List<IncidenteSST> incidentes) {
        return incidentes.stream()
                .collect(Collectors.groupingBy(i -> i.getTipo().name(), Collectors.counting()));
    }

    private MotivoAusentismo motivoPorTipoIncidente(IncidenteSST incidente) {
        if (incidente.getTipo() == co.edu.cesde.hrm.retention.domain.enums.TipoIncidente.ACCIDENTE_TRABAJO) {
            return MotivoAusentismo.ACCIDENTE_TRABAJO;
        }
        return MotivoAusentismo.INCAPACIDAD_MEDICA;
    }

    private IncidenteDTO toDto(IncidenteSST incidente) {
        IncidenteDTO dto = new IncidenteDTO();
        dto.setId(incidente.getId());
        dto.setEmpleadoId(incidente.getEmpleadoId());
        dto.setNombreEmpleado(incidente.getNombreEmpleado());
        dto.setTipo(incidente.getTipo());
        dto.setDescripcion(incidente.getDescripcion());
        dto.setFecha(incidente.getFecha());
        dto.setDiasIncapacidad(incidente.getDiasIncapacidad());
        dto.setEstado(incidente.getEstado());
        dto.setMedidasCorrectivas(incidente.getMedidasCorrectivas());
        dto.setAlerta(incidente.esCritico() ? incidente.generarAlerta() : null);
        return dto;
    }

    private ProgramaDTO toDto(ProgramaBienestar programa) {
        ProgramaDTO dto = new ProgramaDTO();
        dto.setId(programa.getId());
        dto.setNombre(programa.getNombre());
        dto.setTipo(programa.getTipo());
        dto.setDescripcion(programa.getDescripcion());
        dto.setFechaInicio(programa.getFechaInicio());
        dto.setFechaFin(programa.getFechaFin());
        dto.setActivo(programa.isActivo());
        dto.setResponsable(programa.getResponsable());
        dto.setVigente(programa.estaVigente());
        return dto;
    }

    private AusentismoDTO toDto(Ausentismo ausentismo) {
        AusentismoDTO dto = new AusentismoDTO();
        dto.setId(ausentismo.getId());
        dto.setEmpleadoId(ausentismo.getEmpleadoId());
        dto.setMotivo(ausentismo.getMotivo());
        dto.setFechaInicio(ausentismo.getFechaInicio());
        dto.setFechaFin(ausentismo.getFechaFin());
        dto.setDiasTotales(ausentismo.getDiasTotales());
        dto.setEsPorIncidente(ausentismo.esPorIncidente());
        return dto;
    }

    private void validateRegistrarIncidente(RegistrarIncidenteCommand command) {
        if (command.getEmpleadoId() == null || command.getTipo() == null || command.getDescripcion() == null || command.getDescripcion().isBlank() || command.getFecha() == null) {
            throw new IllegalArgumentException("Campos obligatorios: empleadoId, tipo, descripcion y fecha.");
        }
    }

    private void validateCrearPrograma(CrearProgramaBienestarCommand command) {
        if (command.getNombre() == null || command.getNombre().isBlank() || command.getTipo() == null || command.getDescripcion() == null || command.getDescripcion().isBlank() || command.getFechaInicio() == null || command.getFechaFin() == null || command.getResponsable() == null || command.getResponsable().isBlank()) {
            throw new IllegalArgumentException("Campos obligatorios: nombre, tipo, fechaInicio, fechaFin y responsable.");
        }
        if (!command.getFechaFin().isAfter(command.getFechaInicio())) {
            throw new IllegalArgumentException("fechaFin debe ser posterior a fechaInicio.");
        }
    }

    private void validateRegistrarAusentismo(RegistrarAusentismoCommand command) {
        if (command.getEmpleadoId() == null || command.getMotivo() == null || command.getFechaInicio() == null || command.getFechaFin() == null) {
            throw new IllegalArgumentException("Campos obligatorios: empleadoId, motivo, fechaInicio y fechaFin.");
        }
        if (command.getFechaFin().isBefore(command.getFechaInicio())) {
            throw new IllegalArgumentException("fechaFin debe ser igual o posterior a fechaInicio.");
        }
    }

    private boolean existenSolapamientos(List<Ausentismo> existentes, LocalDate inicio, LocalDate fin) {
        return existentes.stream().anyMatch(a -> !a.getFechaInicio().isAfter(fin) && !a.getFechaFin().isBefore(inicio));
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\"", "\"\"").replace("\n", " ").replace("\r", " ");
    }
}
