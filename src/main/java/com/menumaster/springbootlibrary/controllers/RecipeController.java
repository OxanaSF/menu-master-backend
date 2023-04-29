package com.menumaster.springbootlibrary.controllers;


import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.services.RecipeService;
import com.menumaster.springbootlibrary.services.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes/getMine")
    public List<RecipeDto> getLocalRecipes() {
        // Достаем все рецепты из базы и конвертируем в DTO
        return recipeService.getAllRecipes().stream().map(RecipeDto::fromDomain).toList();
    }

    @PostMapping("/recipes")
    public long saveNewRecipe(@RequestBody RecipeDto recipeDto) {
        // Конвертируем из DTO в доменную модель
        return recipeService.saveRecipe(recipeDto.toDomain()).getRecipe_id();
    }


}
