package com.menumaster.springbootlibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.menumaster.springbootlibrary.entites.RecipeIngredient;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

}
