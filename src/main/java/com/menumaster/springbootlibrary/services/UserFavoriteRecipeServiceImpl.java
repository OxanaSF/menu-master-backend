package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.UserFavoriteRecipe;
import com.menumaster.springbootlibrary.repositories.UserFavoriteRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteRecipeServiceImpl implements UserFavoriteRecipeService {

    private final UserFavoriteRecipeRepository userFavoriteRecipeRepository;

    public UserFavoriteRecipeServiceImpl(UserFavoriteRecipeRepository userFavoriteRecipeRepository) {
        this.userFavoriteRecipeRepository = userFavoriteRecipeRepository;
    }

    @Override
    public List<UserFavoriteRecipe> getAllUserFavoriteRecipes() {
        return userFavoriteRecipeRepository.findAll();
    }

    @Override
    public UserFavoriteRecipe getUserFavoriteRecipeById(Long id) {
        return userFavoriteRecipeRepository.findById(id).orElse(null);
    }

    @Override
    public UserFavoriteRecipe saveUserFavoriteRecipe(UserFavoriteRecipe userFavoriteRecipe) {
        return userFavoriteRecipeRepository.save(userFavoriteRecipe);
    }

    @Override
    public void deleteUserFavoriteRecipe(Long id) {
        userFavoriteRecipeRepository.deleteById(id);
    }
}
