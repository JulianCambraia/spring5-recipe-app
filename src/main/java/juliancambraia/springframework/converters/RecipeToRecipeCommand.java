package juliancambraia.springframework.converters;

import juliancambraia.springframework.commands.RecipeCommand;
import juliancambraia.springframework.domain.Category;
import juliancambraia.springframework.domain.Ingredient;
import juliancambraia.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author juliancambraia
 * @implNote
 */

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final NotesToNotesCommand notesConverter;
    private final IngredientToIngredientCommand ingredientConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, NotesToNotesCommand notesConverter, IngredientToIngredientCommand ingredientConverter) {
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setPrepTIme(recipe.getPrepTime());
        recipeCommand.setDifficulty(recipe.getDifficultyEnum());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setNotes(notesConverter.convert(recipe.getNotes()));

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
            recipe.getCategories().forEach((Category category) -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
        }

        if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0) {
            recipe.getIngredients().forEach((Ingredient ingredient) -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipeCommand;
    }
}
