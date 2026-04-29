package co.edu.cesde.hrm.retention.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProgramaBienestarJpaRepository extends JpaRepository<ProgramaBienestarJpaEntity, Long> {
    Optional<ProgramaBienestarJpaEntity> findByNombre(String nombre);
}
