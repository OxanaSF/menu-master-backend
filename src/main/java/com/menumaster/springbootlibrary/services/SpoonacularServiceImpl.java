package com.menumaster.springbootlibrary.services;


import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.spoonacular.SpoonacularRecipe;
import com.menumaster.springbootlibrary.spoonacular.SpoonacularResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpoonacularServiceImpl implements SpoonacularService {

    private final RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    @Autowired
    public SpoonacularServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Recipe> getSpoonacularRecipes(int limit) {
        // Формируем ссылку запрос
        String url = "https://api.spoonacular.com/recipes/search?apiKey=" + apiKey + "&number=" + limit;
        // Отправляем запрос получаем ответ
        SpoonacularResponse response = restTemplate.getForObject(url, SpoonacularResponse.class);
        // Если ответа нет отправляем пустой ответ чтобы не ломать логику
        if (response == null) {
            return List.of();
        }
        // Если ответ есть конвертируем его в наше представление и возвращаем
        List<Recipe> res = response.getResults().stream().map(SpoonacularRecipe::toDomain).toList();
        return res;
    }


    @Override
    public String getSpoonacularRecipesInSearchBar(String query, int limit, boolean instructionsRequired, boolean addRecipeInformation) {
        String url = "https://api.spoonacular.com/recipes/complexSearch?apiKey=" + apiKey + "&number=" + limit + "&query=" + query + "&instructionsRequired=true&addRecipeInformation=true";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    @Override
    public RecipeDto getSpoonacularRecipeById(int spoonacularId) {
        String url = "https://api.spoonacular.com/recipes/" + spoonacularId + "/information?apiKey=" + apiKey + "&includeNutrition=true";
        SpoonacularRecipe response = restTemplate.getForObject(url, SpoonacularRecipe.class);
        if (response == null) {
            return null;
        }
        RecipeDto res = RecipeDto.fromDomain(response.toDomain());
        System.out.println("**************************");
        System.out.println(response);
        System.out.println("**************************");
        return res;
    }


}


