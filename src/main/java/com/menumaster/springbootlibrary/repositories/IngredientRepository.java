package com.menumaster.springbootlibrary.repositories;

import com.menumaster.springbootlibrary.entites.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
