package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.UserFavoriteRecipe;

import java.util.List;

public interface UserFavoriteRecipeService {
    List<UserFavoriteRecipe> getAllUserFavoriteRecipes();
    UserFavoriteRecipe getUserFavoriteRecipeById(Long id);
    UserFavoriteRecipe saveUserFavoriteRecipe(UserFavoriteRecipe userFavoriteRecipe);
    void deleteUserFavoriteRecipe(Long id);
}
