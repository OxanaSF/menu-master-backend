package com.menumaster.springbootlibrary.dtos;

public class SavedMealPlanDto {

    private String mealPlanData;

    public SavedMealPlanDto() {
    }

    public SavedMealPlanDto(String mealPlanData) {
        this.mealPlanData = mealPlanData;
    }

    public String getMealPlanData() {
        return mealPlanData;
    }

    public void setMealPlanData(String mealPlanData) {
        this.mealPlanData = mealPlanData;
    }
}
