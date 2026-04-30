package co.edu.cesde.hrm.retention.application.port.input;

import co.edu.cesde.hrm.retention.application.dto.AusentismoDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteCierreDTO;
import co.edu.cesde.hrm.retention.application.dto.IncidenteDTO;
import co.edu.cesde.hrm.retention.application.dto.IndicadoresDTO;
import co.edu.cesde.hrm.retention.application.dto.ProgramaDTO;
import co.edu.cesde.hrm.retention.application.dto.command.CerrarIncidenteCommand;
import co.edu.cesde.hrm.retention.application.dto.command.CrearProgramaBienestarCommand;
import co.edu.cesde.hrm.retention.application.dto.command.RegistrarAusentismoCommand;
import co.edu.cesde.hrm.retention.application.dto.command.RegistrarIncidenteCommand;

import java.util.List;

public interface SSTServicePort {
    IncidenteDTO registrarIncidente(RegistrarIncidenteCommand command);
    void investigarIncidente(Long id);
    IncidenteCierreDTO cerrarIncidente(Long id, CerrarIncidenteCommand command);
    ProgramaDTO crearProgramaBienestar(CrearProgramaBienestarCommand command);
    AusentismoDTO registrarAusentismo(RegistrarAusentismoCommand command);
    IndicadoresDTO indicadoresPorEmpleado(Long id, Integer periodo);
    IndicadoresDTO indicadoresGlobales(Integer periodo);
    byte[] exportarCSV(String tipo, String estado);
    List<ProgramaDTO> listarProgramas();
    List<ProgramaDTO> listarProgramasActivos();
    List<AusentismoDTO> historialAusentismoPorEmpleado(Long empleadoId);
    IncidenteDTO buscarIncidentePorId(Long id);
}
