package com.menumaster.springbootlibrary.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "saved_meal_plans")
public class SavedMealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "plan_name", length = 150)
    private String planName;

    @Column(name = "meal_plan_data", columnDefinition = "json", length = 20000)
    private String mealPlanData;

    public SavedMealPlan(Long id, Long userId, Long planId, String mealPlanData, String planName) {
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.mealPlanData = mealPlanData;
        this.planName = planName;
    }

    public SavedMealPlan() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public String getMealPlanData() {
        return mealPlanData;
    }

    public String getPlanName() {
        return planName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public void setMealPlanData(String mealPlanData) {
        this.mealPlanData = mealPlanData;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}