package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(Long id);
    List<Recipe> getAllRecipes();
    List<Recipe> getAllRecipesLimited();
    Recipe saveRecipe(Recipe recipe);
    void deleteRecipe(Long id);
    Recipe getRecipeFromSpoonacularApi(String recipeId);
    List<Recipe> searchRecipes(String query);
    Collection<Recipe> getFavoriteRecipes();

    Recipe getRecipeBySpoonacularId(int spoonacularId);
}