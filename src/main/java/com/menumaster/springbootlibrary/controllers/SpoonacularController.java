package com.menumaster.springbootlibrary.controllers;


import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.entites.Recipe;
import com.menumaster.springbootlibrary.services.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SpoonacularController {

    private final SpoonacularService spoonacularService;

    @Autowired
    public SpoonacularController(SpoonacularService spoonacularService) {
        this.spoonacularService = spoonacularService;
    }

    @GetMapping("/recipes")
    @ResponseBody
    public List<RecipeDto> getSpoonacularRecipes(@RequestParam(name = "limit", defaultValue = "10") int limit) {
        // конвертируем из доменного в транспортное представление и отправляем
        return spoonacularService.getSpoonacularRecipes(limit).stream().map(RecipeDto::fromDomain).toList();
    }
}
