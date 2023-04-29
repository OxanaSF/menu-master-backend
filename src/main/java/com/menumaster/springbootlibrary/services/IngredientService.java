package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id);
    Ingredient updateIngredient(Long id, Ingredient ingredient);
    void deleteIngredient(Long id);
    List<Ingredient> getAllIngredients();
}
