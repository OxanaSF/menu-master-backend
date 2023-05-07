package com.menumaster.springbootlibrary.dtos;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.entites.User;

import java.io.Serializable;

public class UserFavoriteRecipeDto implements Serializable {
    private User user;
    private Recipe recipe;

    public UserFavoriteRecipeDto(User user, Recipe recipe) {
        this.user = user;
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
