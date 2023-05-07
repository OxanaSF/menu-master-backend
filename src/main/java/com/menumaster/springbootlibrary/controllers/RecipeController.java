package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.entites.User;
import com.menumaster.springbootlibrary.services.RecipeService;
import com.menumaster.springbootlibrary.services.SpoonacularService;
import com.menumaster.springbootlibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private SpoonacularService spoonacularService;

    @Autowired
    private UserService userService; // Add this line to inject UserService

    @GetMapping("/{spoonacularId}")
    public RecipeDto getRecipeBySpoonacularId(@PathVariable int spoonacularId) {
        return RecipeDto.fromDomain(recipeService.getRecipeBySpoonacularId(spoonacularId));
    }

    @PostMapping("/{userId}/recipes/{spoonacularId}")
    public ResponseEntity<String> saveNewRecipe(@PathVariable long userId, @PathVariable int spoonacularId) {
        Recipe recipe = new Recipe();

        // Associate the user ID with the recipe
        recipe.setUserId(userId);
        recipe.setSpoonacularId(spoonacularId);

        Recipe savedRecipe = recipeService.saveRecipe(recipe);

        if (savedRecipe != null) {
            // Retrieve the user from the database based on the user ID
            User user = userService.getUserById(userId);
            if (user != null) {
                // Associate the saved recipe with the user
                user.getFavoriteRecipes().add(savedRecipe);
                userService.saveUser(user);
            }
            return ResponseEntity.ok("Recipe saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save recipe");
        }
    }


    @GetMapping("/recipes/getMine")
    public List<RecipeDto> getLocalRecipes() {
        // Get all recipes from the database and convert to DTO
        return recipeService.getAllRecipes().stream().map(RecipeDto::fromDomain).toList();
    }
}
