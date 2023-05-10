package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/{spoonacularId}")
    public RecipeDto getRecipeBySpoonacularId(@PathVariable int spoonacularId) {
        return RecipeDto.fromDomain(recipeService.getRecipeBySpoonacularId(spoonacularId));
    }

    @PostMapping("/{userId}/recipes/{spoonacularId}")
    public ResponseEntity<String> saveNewRecipe(@RequestBody RecipeDto newRecipe, @PathVariable long userId) {
        return recipeService.createRecipe(newRecipe, userId);
    }


    @GetMapping(value = "/{userId}/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecipeDto>> getUserRecipes(@PathVariable String userId) {
        List<RecipeDto> recipes = recipeService.getUserRecipes(userId);
        return ResponseEntity.ok(recipes);
    }

}


