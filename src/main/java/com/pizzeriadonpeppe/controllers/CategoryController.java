package com.pizzeriadonpeppe.controllers;

import com.pizzeriadonpeppe.DTOs.CategoryCreateDTO;
import com.pizzeriadonpeppe.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public String createCategory(@Valid @ModelAttribute("categoryCreateDTO")CategoryCreateDTO dto,
                                 BindingResult bindingResult,
                                 RedirectAttributes flash){

        flash.addFlashAttribute("openCategoryModal",true);

        if (bindingResult.hasErrors()){
            flash.addFlashAttribute("categoryError","El nombre de la categoria es obligatorio");
            return "redirect:/products";}

        if(categoryService.existByName(dto.getName())){
            flash.addFlashAttribute("categoryError","La categoria ingresada ya existe");
            return "redirect:/products";}

        try {
            categoryService.createCategory(dto);
            flash.addFlashAttribute("categorySuccess","Categoria creada con exito");
        } catch (DataIntegrityViolationException e) {
            flash.addFlashAttribute("categoryError","La categoria ingresada ya existe");
        }
        return "redirect:/products";
    }

    @PostMapping("/{id}/activate")
    public String activateCategory(@PathVariable Long id, RedirectAttributes flash){
        flash.addFlashAttribute("openCategoryModal",true);
        categoryService.activateCategory(id);
        return "redirect:/products";
    }

    @PostMapping("/{id}/desactivate")
    public String desactivateCategory(@PathVariable Long id, RedirectAttributes flash){
        flash.addFlashAttribute("openCategoryModal",true);
        categoryService.desactivateCategory(id);
        return "redirect:/products";
    }
}
