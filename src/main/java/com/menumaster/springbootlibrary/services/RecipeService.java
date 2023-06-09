package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(Long id);
    List<Recipe> getAllRecipes();
    List<Recipe> getAllRecipesLimited();
    Recipe saveRecipe(Recipe recipe);
    void deleteRecipe(Long userId, int spoonacularId);


    Recipe getRecipeFromSpoonacularApi(String recipeId);
    List<Recipe> searchRecipes(String query);
    Recipe getRecipeBySpoonacularId(int spoonacularId);
    public ResponseEntity<String> createRecipe(RecipeDto recipeDto, long userId);
    List<RecipeDto> getUserRecipes(String userId);
    public boolean recipeExists(RecipeDto recipe, long userId);
    boolean recipeExistsByUserIdAndSpoonacularId(long userId, int spoonacularId);



}