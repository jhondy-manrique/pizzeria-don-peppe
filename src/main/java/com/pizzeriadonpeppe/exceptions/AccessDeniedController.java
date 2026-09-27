package com.pizzeriadonpeppe.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/access-denied")
    public String getAccessDeniedPage(){
        return "error/access-denied";
    }
}
