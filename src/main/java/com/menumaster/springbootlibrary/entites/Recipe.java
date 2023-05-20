package com.menumaster.springbootlibrary.entites;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipe", uniqueConstraints = {
        @UniqueConstraint(columnNames = "spoonacular_id")
})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "name")
    private String name;
    @Column(name = "cuisine_type")
    private String cuisineType;
    @Column(name = "instructions", columnDefinition = "json", length = 3000)
    private String instructions;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "serving_size")
    private int servingSize;
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "nutritional_information", length = 2000)
    private String nutritionalInformation;

    @Column(name = "spoonacular_id")
    private int spoonacularId;

//    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @ManyToMany(mappedBy = "favoriteRecipes")
    private List<User> users = new ArrayList<>();
    private Long userId;


    public void setDescription(String description) {
        this.description = description;
    }

    public void setServingSize(Integer servingSize) {
        this.servingSize = servingSize;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public  Recipe(RecipeDto recipe) {
        this.recipeId = recipe.getRecipeId();
        this.name = recipe.getName();
        this.cuisineType = recipe.getCuisineType();
        this.description = recipe.getDescription();
        this.servingSize = recipe.getServingSize();
        this.imageUrl = recipe.getImageUrl();
        this.nutritionalInformation = recipe.getNutritionalInformation();
        this.instructions = recipe.getInstructions();
        this.spoonacularId = recipe.getSpoonacularId();
    }


    public static Recipe fromDomain(RecipeDto recipeDto) {
        return Recipe.builder()
                .recipeId(recipeDto.getRecipeId())
                .name(recipeDto.getName())
                .cuisineType(recipeDto.getCuisineType())
                .description(recipeDto.getDescription())
                .servingSize(recipeDto.getServingSize())
                .imageUrl(recipeDto.getImageUrl())
                .nutritionalInformation(recipeDto.getNutritionalInformation())
                .instructions(recipeDto.getInstructions())
                .spoonacularId(recipeDto.getSpoonacularId())
                .build();
    }
}