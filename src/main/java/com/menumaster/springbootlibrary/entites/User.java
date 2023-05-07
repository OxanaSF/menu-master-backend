package com.menumaster.springbootlibrary.entites;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dietary_restrictions")
    private String dietaryRestrictions = "";

    @Column(name = "preferred_cuisine_types")
    private String preferredCuisineTypes = "";

    @Column(name = "grocery_list")
    private String groceryList = "";

    @Column(name = "individual_menu")
    private String individualMenu = "";

    @ManyToMany
    @JoinTable(
            name = "user_favorite_recipe",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> favoriteRecipes = new ArrayList<>();

    public User(UserDto user) {
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