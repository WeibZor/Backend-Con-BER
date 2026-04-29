package co.edu.cesde.hrm.retention.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AusentismoJpaRepository extends JpaRepository<AusentismoJpaEntity, Long> {
    List<AusentismoJpaEntity> findByEmpleadoId(Long empleadoId);
}
