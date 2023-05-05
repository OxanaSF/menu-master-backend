package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpoonacularService {

    /**
     * Requests recipes from Spoonacular endpoint and converts em to the our format;
     *
     * @param limit limit of recipes
     * @return list of resutls
     */
    List<Recipe> getSpoonacularRecipes(int limit);

    RecipeDto getRecipeById(int spoonacularId);
}