package com.pizzeriadonpeppe.service;

import com.pizzeriadonpeppe.DTOs.CategoryCreateDTO;
import com.pizzeriadonpeppe.DTOs.ShowCategoryDTO;
import com.pizzeriadonpeppe.entities.Category;
import com.pizzeriadonpeppe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createCategory(CategoryCreateDTO dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<ShowCategoryDTO> findAllCategories(){
        return categoryRepository.findAll().stream().map(
                (category)->{
                    ShowCategoryDTO dto = new ShowCategoryDTO();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setDescription(category.getDescription());
                    dto.setActive(category.isActive());
                    return dto;
                }
        ).toList();
    }

    @Transactional(readOnly = true)
    public List<ShowCategoryDTO> findActiveCategories(){
        return categoryRepository.findAllByIsActiveTrueOrderByNameAsc().stream().map(
                (category)->{
                    ShowCategoryDTO dto = new ShowCategoryDTO();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    dto.setDescription(category.getDescription());
                    dto.setActive(category.isActive());
                    return dto;
                }
        ).toList();
    }

    @Transactional(readOnly = true)
    public boolean existByName(String name) {
        return categoryRepository.existsByNameIgnoreCase(name);
    }
}
