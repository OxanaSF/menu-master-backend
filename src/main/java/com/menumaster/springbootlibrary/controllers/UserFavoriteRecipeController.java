package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.entites.UserFavoriteRecipe;
import com.menumaster.springbootlibrary.services.UserFavoriteRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userFavoriteRecipes")
public class UserFavoriteRecipeController {

    @Autowired
    private UserFavoriteRecipeService userFavoriteRecipeService;

    @GetMapping
    public ResponseEntity<List<UserFavoriteRecipe>> getAllUserFavoriteRecipes() {
        List<UserFavoriteRecipe> userFavoriteRecipes = userFavoriteRecipeService.getAllUserFavoriteRecipes();
        return new ResponseEntity<>(userFavoriteRecipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFavoriteRecipe> getUserFavoriteRecipeById(@PathVariable Long id) {
        UserFavoriteRecipe userFavoriteRecipe = userFavoriteRecipeService.getUserFavoriteRecipeById(id);
        if (userFavoriteRecipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userFavoriteRecipe, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserFavoriteRecipe> saveUserFavoriteRecipe(@RequestBody UserFavoriteRecipe userFavoriteRecipe) {
        UserFavoriteRecipe savedUserFavoriteRecipe = userFavoriteRecipeService.saveUserFavoriteRecipe(userFavoriteRecipe);
        return new ResponseEntity<>(savedUserFavoriteRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFavoriteRecipe> updateUserFavoriteRecipe(@PathVariable Long id, @RequestBody UserFavoriteRecipe userFavoriteRecipe) {
        UserFavoriteRecipe existingUserFavoriteRecipe = userFavoriteRecipeService.getUserFavoriteRecipeById(id);
        if (existingUserFavoriteRecipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userFavoriteRecipe.setId(id);
        UserFavoriteRecipe updatedUserFavoriteRecipe = userFavoriteRecipeService.saveUserFavoriteRecipe(userFavoriteRecipe);
        return new ResponseEntity<>(updatedUserFavoriteRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFavoriteRecipe(@PathVariable Long id) {
        UserFavoriteRecipe existingUserFavoriteRecipe = userFavoriteRecipeService.getUserFavoriteRecipeById(id);
        if (existingUserFavoriteRecipe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userFavoriteRecipeService.deleteUserFavoriteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
