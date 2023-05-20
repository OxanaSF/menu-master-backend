package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.repositories.RecipeRepository;
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

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/{spoonacularId}")
    public RecipeDto getRecipeBySpoonacularId(@PathVariable int spoonacularId) {
        return RecipeDto.fromDomain(recipeService.getRecipeBySpoonacularId(spoonacularId));
    }


    @PostMapping("/{userId}/recipes/{spoonacularId}")
    public ResponseEntity<String> saveNewRecipe(@RequestBody RecipeDto newRecipe, @PathVariable long userId, @PathVariable int spoonacularId) {
        boolean recipeExists = recipeRepository.existsByUserIdAndSpoonacularId(userId, spoonacularId);
        if (recipeExists) {
            return ResponseEntity.ok("Recipe is already exist.");
        } else {
            return recipeService.createRecipe(newRecipe, userId);
        }
    }

    @DeleteMapping("/{userId}/recipes/{spoonacularId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable long userId, @PathVariable int spoonacularId) {
        boolean recipeExists = recipeService.recipeExistsByUserIdAndSpoonacularId(userId, spoonacularId);
        if (recipeExists) {
            recipeService.deleteRecipe(userId, spoonacularId);
            return ResponseEntity.ok("Recipe deleted successfully.");
        } else {
            return ResponseEntity.ok("The recipe does not exist.");
        }
    }




    @GetMapping(value = "/{userId}/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecipeDto>> getUserRecipes(@PathVariable String userId) {
        List<RecipeDto> recipes = recipeService.getUserRecipes(userId);
        return ResponseEntity.ok(recipes);
    }


}


