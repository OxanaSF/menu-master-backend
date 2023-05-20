package com.menumaster.springbootlibrary.dtos;

public class SavedMealPlanDto {

    private String mealPlanData;
    private String planName;

    public SavedMealPlanDto() {
    }

    public SavedMealPlanDto(String mealPlanData, String planName) {
        this.mealPlanData = mealPlanData;
        this.planName = planName;
    }

    public String getMealPlanData() {
        return mealPlanData;
    }

    public void setMealPlanData(String mealPlanData) {
        this.mealPlanData = mealPlanData;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}
