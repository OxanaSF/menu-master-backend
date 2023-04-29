package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.RecipeIngredient;
import com.menumaster.springbootlibrary.repositories.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public List<RecipeIngredient> getAllRecipeIngredients() {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        recipeIngredientRepository.findAll().forEach(recipeIngredients::add);
        return recipeIngredients;
    }

    @Override
    public RecipeIngredient getRecipeIngredientById(Long id) {
        return recipeIngredientRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeIngredient saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public void deleteRecipeIngredient(Long id) {
        recipeIngredientRepository.deleteById(id);
    }


}
