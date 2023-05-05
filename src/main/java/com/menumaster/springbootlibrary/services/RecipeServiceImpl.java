package com.menumaster.springbootlibrary.services;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.entites.User;
import com.menumaster.springbootlibrary.repositories.RecipeRepository;
import com.menumaster.springbootlibrary.services.RecipeService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;







import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

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
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
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
    public List<Recipe> getFavoriteRecipes() {
//        // Get the current user (you will need to define a way to get the current user)
//        User currentUser = getCurrentUser();
//
//        // Get all the favorite recipes for the current user
//        List<FavoriteRecipe> favoriteRecipes = favoriteRecipeRepository.findByUser(currentUser);
//
//        // Convert the list of favorite recipes to a list of recipes
//        List<Recipe> recipes = favoriteRecipes.stream()
//                .map(FavoriteRecipe::getRecipe)
//                .collect(Collectors.toList());
//
//        return recipes;
        return null;
    }

    @Override
    public Recipe getRecipeBySpoonacularId(int spoonacularId) {
        return null;
    }


}
