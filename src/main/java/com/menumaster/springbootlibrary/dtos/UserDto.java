package com.menumaster.springbootlibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long userId;
    private String username;
    private String dietaryRestrictions;
    private String preferredCuisineTypes;
    private String groceryList;
    private String individualMenu;
    private List<RecipeDto> favoriteRecipes;



    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
    public String getPreferredCuisineTypes() {
        return preferredCuisineTypes;
    }
    public void setPreferredCuisineTypes(String preferredCuisineTypes) {
        this.preferredCuisineTypes = preferredCuisineTypes;
    }

    public String getGroceryList() {
        return groceryList;
    }
    public void setGroceryList(String groceryList) {
        this.groceryList = groceryList;
    }
    public String getIndividualMenu() {
        return individualMenu;
    }
    public void setIndividualMenu(String individualMenu) {
        this.individualMenu = individualMenu;
    }
    public List<RecipeDto> getFavoriteRecipes() {
        return favoriteRecipes;
    }
    public void setFavoriteRecipes(List<RecipeDto> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }
}
