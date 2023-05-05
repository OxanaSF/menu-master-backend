package com.menumaster.springbootlibrary.controllers;


import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.services.RecipeService;
import com.menumaster.springbootlibrary.services.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private SpoonacularService spoonacularService;

    @GetMapping("/{spoonacularId}")
    public RecipeDto getRecipeBySpoonacularId(@PathVariable int spoonacularId) {
        return RecipeDto.fromDomain(recipeService.getRecipeBySpoonacularId(spoonacularId));
    }


//    @PostMapping("/{spoonacularId}")
//    public long saveNewRecipe(@PathVariable int spoonacularId) {
//        RecipeDto recipeDto = spoonacularService.getRecipeById(spoonacularId);
//        Recipe recipe = recipeDto.toDomain();
//        return recipeService.saveRecipe(recipe).getRecipe_id();
//    }
//
//    @GetMapping("/favorites")
//    public List<RecipeDto> getFavoriteRecipes() {
//        // Get the favorite recipes for the current user and convert to DTO
//        return recipeService.getFavoriteRecipes().stream().map(RecipeDto::fromDomain).toList();
//    }


    @GetMapping("/recipes/getMine")
    public List<RecipeDto> getLocalRecipes() {
        // Достаем все рецепты из базы и конвертируем в DTO
        return recipeService.getAllRecipes().stream().map(RecipeDto::fromDomain).toList();
    }

}
