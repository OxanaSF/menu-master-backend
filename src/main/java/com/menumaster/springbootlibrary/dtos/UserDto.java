package com.menumaster.springbootlibrary.dtos;

import com.menumaster.springbootlibrary.entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dietaryRestrictions;
    private String preferredCuisineTypes;
    private String groceryList;
    private String individualMenu;
    private List<RecipeDto> favoriteRecipes;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dietaryRestrictions = user.getDietaryRestrictions();
        this.preferredCuisineTypes = user.getPreferredCuisineTypes();
        this.groceryList = user.getGroceryList();
        this.individualMenu = user.getIndividualMenu();
    }
}
