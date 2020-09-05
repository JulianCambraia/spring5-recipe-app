package juliancambraia.springframework.repositories;

import juliancambraia.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
