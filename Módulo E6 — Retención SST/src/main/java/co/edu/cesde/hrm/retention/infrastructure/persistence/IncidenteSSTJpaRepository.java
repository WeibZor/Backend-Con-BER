package co.edu.cesde.hrm.retention.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncidenteSSTJpaRepository extends JpaRepository<IncidenteSSTJpaEntity, Long> {
    List<IncidenteSSTJpaEntity> findByEmpleadoId(Long empleadoId);
    List<IncidenteSSTJpaEntity> findByTipo(String tipo);
}
