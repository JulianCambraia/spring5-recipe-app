package juliancambraia.springframework.repositories;

import juliancambraia.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
