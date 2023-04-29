package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.entites.RecipeIngredient;
import com.menumaster.springbootlibrary.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe-ingredients")
public class RecipeIngredientController {

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @GetMapping
    public List<RecipeIngredient> getAllRecipeIngredients() {
        return recipeIngredientService.getAllRecipeIngredients();
    }

    @GetMapping("/{id}")
    public RecipeIngredient getRecipeIngredientById(@PathVariable Long id) {
        return recipeIngredientService.getRecipeIngredientById(id);
    }

    @PostMapping
    public RecipeIngredient createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        return recipeIngredientService.saveRecipeIngredient(recipeIngredient);
    }

    @PutMapping("/{id}")
    public RecipeIngredient updateRecipeIngredient(@PathVariable Long id, @RequestBody RecipeIngredient recipeIngredient) {
        return recipeIngredientService.saveRecipeIngredient(recipeIngredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeIngredient(@PathVariable Long id) {
        recipeIngredientService.deleteRecipeIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
