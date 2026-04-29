package co.edu.cesde.hrm.retention.infrastructure.rest;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sst")
@Validated
public class SSTController {

    private final SSTServicePort sstServicePort;

    public SSTController(SSTServicePort sstServicePort) {
        this.sstServicePort = sstServicePort;
    }

    @PostMapping("/incidentes")
    public ResponseEntity<IncidenteDTO> registrarIncidente(@RequestBody RegistrarIncidenteCommand command) {
        try {
            IncidenteDTO dto = sstServicePort.registrarIncidente(command);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/incidentes/{id}")
    public ResponseEntity<IncidenteDTO> buscarIncidente(@PathVariable Long id) {
        try {
            IncidenteDTO dto = sstServicePort.buscarIncidentePorId(id);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/incidentes/{id}/investigar")
    public ResponseEntity<Void> investigarIncidente(@PathVariable Long id) {
        try {
            sstServicePort.investigarIncidente(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException | IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PutMapping("/incidentes/{id}/cerrar")
    public ResponseEntity<IncidenteCierreDTO> cerrarIncidente(@PathVariable Long id, @RequestBody CerrarIncidenteCommand command) {
        try {
            IncidenteCierreDTO dto = sstServicePort.cerrarIncidente(id, command);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PostMapping("/bienestar")
    public ResponseEntity<ProgramaDTO> crearPrograma(@RequestBody CrearProgramaBienestarCommand command) {
        try {
            ProgramaDTO dto = sstServicePort.crearProgramaBienestar(command);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/bienestar")
    public List<ProgramaDTO> listarProgramas() {
        return sstServicePort.listarProgramas();
    }

    @GetMapping("/bienestar/activos")
    public List<ProgramaDTO> listarProgramasActivos() {
        return sstServicePort.listarProgramasActivos();
    }

    @PostMapping("/ausentismo")
    public ResponseEntity<AusentismoDTO> registrarAusentismo(@RequestBody RegistrarAusentismoCommand command) {
        try {
            AusentismoDTO dto = sstServicePort.registrarAusentismo(command);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/ausentismo/empleado/{empleadoId}")
    public List<AusentismoDTO> historialAusentismo(@PathVariable Long empleadoId) {
        return sstServicePort.historialAusentismoPorEmpleado(empleadoId);
    }

    @GetMapping("/indicadores")
    public IndicadoresDTO indicadoresGlobales(@RequestParam(required = false) Integer periodo) {
        return sstServicePort.indicadoresGlobales(periodo);
    }

    @GetMapping("/indicadores/empleado/{empleadoId}")
    public IndicadoresDTO indicadoresPorEmpleado(@PathVariable Long empleadoId, @RequestParam(required = false) Integer periodo) {
        return sstServicePort.indicadoresPorEmpleado(empleadoId, periodo);
    }

    @GetMapping("/export/csv")
    public ResponseEntity<byte[]> exportarCsv(@RequestParam(required = false) String tipo,
                                              @RequestParam(required = false) String estado) {
        byte[] content = sstServicePort.exportarCSV(tipo, estado);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sst.csv");
        return ResponseEntity.ok().headers(headers).body(content);
    }
}
