package juliancambraia.springframework.services;

import juliancambraia.springframework.commands.RecipeCommand;
import juliancambraia.springframework.domain.Recipe;

import java.util.Set;

/**
 * @author juliancambraia
 */

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
