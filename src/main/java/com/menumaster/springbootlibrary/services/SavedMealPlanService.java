package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.SavedMealPlan;
import com.menumaster.springbootlibrary.repositories.SavedMealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedMealPlanService {

    private final SavedMealPlanRepository savedMealPlanRepository;

    @Autowired
    public SavedMealPlanService(SavedMealPlanRepository savedMealPlanRepository) {
        this.savedMealPlanRepository = savedMealPlanRepository;
    }

    public SavedMealPlan save(SavedMealPlan savedMealPlan) {
        return savedMealPlanRepository.save(savedMealPlan);
    }

    public List<SavedMealPlan> getSavedMealPlansByUserId(Long userId) {
        return savedMealPlanRepository.findByUserId(userId);
    }

    public void deleteSavedMealPlan(Long id) {
        savedMealPlanRepository.deleteById(id);
    }
}