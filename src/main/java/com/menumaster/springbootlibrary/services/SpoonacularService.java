package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpoonacularService {
    List<Recipe> getSpoonacularRecipes(int limit);
    String getSpoonacularRecipesInSearchBar(String query, int limit, boolean instructionsRequired, boolean addRecipeInformation);
    RecipeDto getSpoonacularRecipeById(int spoonacularId);
}