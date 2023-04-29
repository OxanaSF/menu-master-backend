package com.menumaster.springbootlibrary.spoonacular;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.menumaster.springbootlibrary.entites.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Data
@NoArgsConstructor
public class SpoonacularResponse implements Serializable {

    private List<SpoonacularRecipe> results = new ArrayList<>();
    private String baseUri;
    private int offset;
    private int number;
    private int totalResults;
    private int processingTimeMs;
    private long expires;
    private boolean isStale;
}
