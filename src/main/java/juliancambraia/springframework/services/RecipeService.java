package juliancambraia.springframework.services;

import juliancambraia.springframework.domain.Recipe;

import java.util.Set;

/**
 * @author juliancambraia
 */

public interface RecipeService {
    Set<Recipe> getRecipes();
}
