package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.entites.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {
    List<RecipeIngredient> getAllRecipeIngredients();
    RecipeIngredient getRecipeIngredientById(Long id);
    RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient);
    void deleteRecipeIngredient(Long id);


}
