package com.menumaster.springbootlibrary.dtos;

import java.io.Serializable;

public class UserFavoriteRecipeDto implements Serializable {
    private Long userId;
    private Long recipeId;

    public UserFavoriteRecipeDto(Long userId, Long recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
