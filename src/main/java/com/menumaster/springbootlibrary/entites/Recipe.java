package com.menumaster.springbootlibrary.entites;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipe")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipe_id;

    @Column(name = "name")
    private String name;
    @Column(name = "cuisine_type")
    private String cuisineType;
    @Column(name = "instructions")
    private String instructions;

    @Column(name = "description")
    private String description;

    @Column(name = "serving_size")
    private Integer servingSize;
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "nutritional_information", columnDefinition = "json")
    private String nutritionalInformation;

    @Column(name = "spoonacular_id")
    private int spoonacularId;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @ManyToMany(mappedBy = "favoriteRecipes")
    private List<User> users = new ArrayList<>();


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

}
