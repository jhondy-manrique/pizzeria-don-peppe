package com.pizzeriadonpeppe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String getViewProducts(){
        return "products";
    }
}
