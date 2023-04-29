package com.menumaster.springbootlibrary.repositories;

import com.menumaster.springbootlibrary.entites.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContainingOrCuisineTypeContainingOrRecipeIngredients_IngredientContaining(String name, String cuisineType, String ingredient);

}
