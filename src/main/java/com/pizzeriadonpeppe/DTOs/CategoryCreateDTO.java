package com.pizzeriadonpeppe.DTOs;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateDTO {

    @NotBlank(message = "el nombre de la categoria es obligatorio")
    private String name;

    private String description;

    public CategoryCreateDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
