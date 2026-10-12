package com.pizzeriadonpeppe.controllers;

import com.pizzeriadonpeppe.DTOs.CategoryCreateDTO;
import com.pizzeriadonpeppe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final CategoryService categoryService;

    @Autowired
    public ProductController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("/products")
    public String getViewProducts(Model model){
        model.addAttribute("categoryCreateDTO", new CategoryCreateDTO());
        model.addAttribute("allCategories", categoryService.findAllCategories());
        return "products";
    }
}
