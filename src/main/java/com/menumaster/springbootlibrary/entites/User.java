package com.menumaster.springbootlibrary.entites;

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
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "dietary_restrictions")
    private String dietaryRestrictions;

    @Column(name = "preferred_cuisine_types")
    private String preferredCuisineTypes;

    @Column(name = "grocery_list", columnDefinition = "json")
    private String groceryList;

    @Column(name = "individual_menu", columnDefinition = "json")
    private String individualMenu;

    @ManyToMany
    @JoinTable(name = "User_Favorite_Recipe",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> favoriteRecipes = new ArrayList<>();



}
