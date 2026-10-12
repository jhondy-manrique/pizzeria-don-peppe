package com.pizzeriadonpeppe.DTOs;

public class ShowCategoryDTO {

    private Long id;
    private String name;
    private String description;
    private boolean isActive;

    public ShowCategoryDTO(String description, Long id, boolean isActive, String name) {
        this.description = description;
        this.id = id;
        this.isActive = isActive;
        this.name = name;
    }

    public ShowCategoryDTO() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
