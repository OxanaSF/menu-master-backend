package com.menumaster.springbootlibrary.repositories;

import com.menumaster.springbootlibrary.entites.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContainingOrCuisineTypeContainingOrRecipeIngredients_IngredientContaining(String name, String cuisineType, String ingredient);
    List<Recipe> findRecipesByUserId(String userId);
    Recipe findBySpoonacularId(int spoonacularId);
    Optional<Recipe> findBySpoonacularIdAndUserId(int spoonacularId, long userId);
    boolean existsByUserIdAndSpoonacularId(Long userId, int spoonacularId);


}
