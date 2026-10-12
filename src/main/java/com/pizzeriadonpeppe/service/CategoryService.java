package com.pizzeriadonpeppe.service;

import com.pizzeriadonpeppe.DTOs.CategoryCreateDTO;
import com.pizzeriadonpeppe.DTOs.ShowCategoryDTO;
import com.pizzeriadonpeppe.entities.Category;
import com.pizzeriadonpeppe.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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
        return categoryRepository.findAllByOrderByName().stream().map(
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


    @Transactional
    public void activateCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Categoría no encontrada con ID: " + id)
        );
        category.setActive(true);
        categoryRepository.save(category);
    }

    @Transactional
    public void desactivateCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Categoría no encontrada con ID: " + id)
        );
        category.setActive(false);
        categoryRepository.save(category);
    }
}
