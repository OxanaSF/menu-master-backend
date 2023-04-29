package com.menumaster.springbootlibrary.spoonacular;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.menumaster.springbootlibrary.entites.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonSerialize
@Data
@NoArgsConstructor
public class SpoonacularRecipe implements Serializable {
    private int readyInMinutes;
    private String sourceUrl;
    private String image;
    private int servings;
    private int id;
    private String title;

    public Recipe toDomain() {
        return Recipe.builder().name(title).imageUrl("https://spoonacular.com/recipeImages/" + image).servingSize(servings).spoonacularId(id).instructions(sourceUrl).build();
    }
}
