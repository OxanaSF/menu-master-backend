package com.menumaster.springbootlibrary.dtos;

import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.spoonacular.SpoonacularRecipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;


@Data
@AllArgsConstructor
@Builder
public class RecipeDto implements Serializable {

    private Long recipeId;
    private String name;
    private String cuisineType;
    private String description;
    private int servingSize;
    private String imageUrl;
    private String nutritionalInformation;
    private String instructions;
    private int spoonacularId;


    public static RecipeDto fromDomain(Recipe domain) {
        return RecipeDto.builder()
                .recipeId(domain.getRecipeId())
                .name(domain.getName())
                .cuisineType(domain.getCuisineType())
                .description(domain.getDescription())
                .servingSize(domain.getServingSize())
                .imageUrl(domain.getImageUrl())
                .nutritionalInformation(domain.getNutritionalInformation())
                .instructions(domain.getInstructions())
                .spoonacularId(domain.getSpoonacularId())
                .build();
    }



    public Recipe toDomain() {
        return Recipe.builder()
                .recipeId(recipeId)
                .name(name)
                .cuisineType(cuisineType)
                .description(description)
                .servingSize(servingSize)
                .imageUrl(imageUrl)
                .nutritionalInformation(nutritionalInformation)
                .instructions(instructions)
                .spoonacularId(spoonacularId)
                .build();
    }


}