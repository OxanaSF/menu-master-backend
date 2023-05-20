package com.menumaster.springbootlibrary.controllers;
import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.services.RecipeService;
import com.menumaster.springbootlibrary.services.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SpoonacularController {

    @Autowired
    private RecipeService recipeService;
    private final SpoonacularService spoonacularService;

    @Autowired
    public SpoonacularController(SpoonacularService spoonacularService) {
        this.spoonacularService = spoonacularService;
    }

    @GetMapping("/recipes")
    @ResponseBody
    public List<RecipeDto> getSpoonacularRecipes(
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return spoonacularService.getSpoonacularRecipes(limit)
                .stream()
                .map(RecipeDto::fromDomain)
                .toList();
    }


    @GetMapping("/recipes/complexSearch")
    @ResponseBody
    public String getSpoonacularRecipesInSearchBar(
            @RequestParam(name = "query") String query,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "instructionsRequired", defaultValue = "true") boolean instructionsRequired,
            @RequestParam(name = "addRecipeInformation", defaultValue = "true") boolean addRecipeInformation
    ) {

        String res = spoonacularService.getSpoonacularRecipesInSearchBar(query, limit, instructionsRequired, addRecipeInformation);
        return res;
    }



    @GetMapping("/spoonacularRecipes/{recipeId}")
    @ResponseBody
    public RecipeDto getSpoonacularRecipeById(
            @PathVariable int recipeId
    ) {
        Recipe recipe = recipeService.getRecipeBySpoonacularId(recipeId);
        RecipeDto res = RecipeDto.fromDomain(recipe);
        return res;

    }


}