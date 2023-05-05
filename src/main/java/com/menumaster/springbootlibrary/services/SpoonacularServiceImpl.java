package com.menumaster.springbootlibrary.services;


import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.spoonacular.SpoonacularRecipe;
import com.menumaster.springbootlibrary.spoonacular.SpoonacularResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        return response.getResults().stream().map(SpoonacularRecipe::toDomain).toList();
    }

    @Override
    public RecipeDto getRecipeById(int spoonacularId) {
        return null;
    }
}
