package com.menumaster.springbootlibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto implements Serializable {

    private Long recipeIngredientId;
    private Long recipeId;
    private Long ingredientId;


}
