package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.dtos.RecipeDto;
import com.menumaster.springbootlibrary.dtos.SavedMealPlanDto;
import com.menumaster.springbootlibrary.entites.SavedMealPlan;
import com.menumaster.springbootlibrary.repositories.SavedMealPlanRepository;
import com.menumaster.springbootlibrary.services.SavedMealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal-plans")
public class SavedMealPlanController {

    private final SavedMealPlanService savedMealPlanService;


    @Autowired
    public SavedMealPlanController(SavedMealPlanService savedMealPlanService) {
        this.savedMealPlanService = savedMealPlanService;
    }

    @PostMapping("/{userId}/save/{planId}")
    public ResponseEntity<String> saveMealPlan(
            @RequestBody SavedMealPlanDto savedMealPlanDto,
            @PathVariable Long userId,
            @PathVariable Long planId) {

            SavedMealPlan savedMealPlan = new SavedMealPlan();
            savedMealPlan.setUserId(userId);
            savedMealPlan.setPlanId(planId);
            savedMealPlan.setMealPlanData(savedMealPlanDto.getMealPlanData());

            SavedMealPlan savedPlan = savedMealPlanService.save(savedMealPlan);
            return ResponseEntity.ok("Meal plan saved successfully with ID: " + savedPlan.getId());

    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> getSavedMealPlansByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(savedMealPlanService.getSavedMealPlansByUserId(userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSavedMealPlan(@PathVariable Long id) {
        savedMealPlanService.deleteSavedMealPlan(id);
        return ResponseEntity.noContent().build();
    }
}