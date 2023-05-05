package com.menumaster.springbootlibrary.dtos;

import com.menumaster.springbootlibrary.entites.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;


@Data
@AllArgsConstructor
@Builder
public class RecipeDto implements Serializable {

    private Long id;
    private String name;
    private String imageUrl;
    private String instructions;
    private int servingsSize;

    public static RecipeDto fromDomain(Recipe domain) {
        return RecipeDto.builder().id(domain.getRecipe_id()).name(domain.getName()).imageUrl(domain.getImageUrl()).instructions(domain.getInstructions()).servingsSize(domain.getServingSize()).build();
    }

    public Recipe toDomain() {
        return Recipe.builder().recipe_id(id).name(name).imageUrl(imageUrl).instructions(instructions).servingSize(servingsSize).build();
    }


}
