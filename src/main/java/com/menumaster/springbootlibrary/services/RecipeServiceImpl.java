package com.menumaster.springbootlibrary.services;
import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.repositories.RecipeRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getAllRecipesLimited() {
        return recipeRepository.findAll(PageRequest.of(0, 30)).getContent();
    }
    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    @Override
    public void deleteRecipe(Long userId, int spoonacularId) {
        Optional<Recipe> recipe = recipeRepository.findBySpoonacularIdAndUserId(spoonacularId, userId);
        recipe.ifPresent(recipeRepository::delete);
    }


    @Override
    public Recipe getRecipeFromSpoonacularApi(String recipeId) {
        String url = "https://api.spoonacular.com/recipes/" + recipeId + "/information?apiKey=" + apiKey;
        Recipe recipe = null;
        try {
            ResponseEntity<SpoonacularRecipeResponseServise> responseEntity = restTemplate.getForEntity(url, SpoonacularRecipeResponseServise.class);
            SpoonacularRecipeResponseServise response = responseEntity.getBody();

            recipe = new Recipe();
            recipe.setName(response.getTitle());
            recipe.setDescription(response.getInstructions());
            recipe.setServingSize(response.getServings());
            recipe.setImageUrl(response.getImage());


            // Save Recipe entity to database
            recipe = saveRecipe(recipe);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public List<Recipe> searchRecipes(String query) {
        List<Recipe> matchingRecipes = recipeRepository.
                findByNameContainingOrCuisineTypeContainingOrRecipeIngredients_IngredientContaining(query, query, query);
        return matchingRecipes;
    }

    @Override
    public Recipe getRecipeBySpoonacularId(int spoonacularId) {
        Recipe recipe = recipeRepository.findBySpoonacularId(spoonacularId);
        return recipe;
    }


//    @Override
//    @Transactional
//    public ResponseEntity<String> createRecipe(RecipeDto recipe, long userId) {
//        List<String> response = new ArrayList<>();
//
//        Recipe newRecipe = recipe.toDomain();
//        newRecipe.setUserId(userId);
//        recipeRepository.save(newRecipe);
//        return ResponseEntity.ok("Recipe created successfully");
//    }

    @Override
    @Transactional
    public ResponseEntity<String> createRecipe(RecipeDto recipe, long userId) {
        List<String> response = new ArrayList<>();

        Recipe newRecipe = new Recipe(recipe);
        newRecipe.setUserId(userId);
        recipeRepository.save(newRecipe);

        return ResponseEntity.ok("Recipe created successfully");
    }




    @Override
    public boolean recipeExists(RecipeDto recipe, long userId) {
        Optional<Recipe> existingRecipe = recipeRepository.findBySpoonacularIdAndUserId(recipe.getSpoonacularId(), userId);
        if (existingRecipe != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<RecipeDto> getUserRecipes(String userId) {
        List<Recipe> recipes = recipeRepository.findRecipesByUserId(userId);

        List<RecipeDto> recipeDtos = recipes.stream()
                .map(RecipeDto::fromDomain)
                .collect(Collectors.toList());

        return recipeDtos;
    }

    @Override
    public boolean recipeExistsByUserIdAndSpoonacularId(long userId, int spoonacularId) {
        return recipeRepository.existsByUserIdAndSpoonacularId(userId, spoonacularId);
    }




}