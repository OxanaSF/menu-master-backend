package com.menumaster.springbootlibrary.repositories;

import com.menumaster.springbootlibrary.entites.SavedMealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedMealPlanRepository extends JpaRepository<SavedMealPlan, Long> {
    List<SavedMealPlan> findByUserId(Long userId);
}
