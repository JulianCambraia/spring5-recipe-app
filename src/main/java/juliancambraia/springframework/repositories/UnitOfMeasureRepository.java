package juliancambraia.springframework.repositories;

import juliancambraia.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
