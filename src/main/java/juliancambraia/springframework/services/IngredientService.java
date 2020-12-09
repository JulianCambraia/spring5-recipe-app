package juliancambraia.springframework.services;

import juliancambraia.springframework.commands.IngredientCommand;

/**
 * @author juliancambraia
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

}
