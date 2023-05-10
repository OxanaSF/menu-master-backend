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



    public  RecipeDto(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        this.name = recipe.getName();
        this.cuisineType = recipe.getCuisineType();
        this.instructions = recipe.getInstructions();
        this.description = recipe.getDescription();
        this.servingSize = recipe.getServingSize();
        this.imageUrl = recipe.getImageUrl();
        this.nutritionalInformation = recipe.getNutritionalInformation();
        this.spoonacularId = recipe.getSpoonacularId();
    }

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


//    public RecipeDto (SpoonacularRecipe spoonacularRecipe) {
//        return RecipeDto.builder()
//        .recipeId()
//                .name(spoonacularRecipe.getTitle())
//                .cuisineType(spoonacularRecipe.)
//                .description(spoonacularRecipe.)
//                .servingSize(spoonacularRecipe.getServings())
//                .imageUrl(spoonacularRecipe.getImage())
//                .nutritionalInformation(spoonacularRecipe.)
//                .instructions(spoonacularRecipe.)
//                .spoonacularId(spoonacularRecipe.getId())
//                .build();
//    }
//



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