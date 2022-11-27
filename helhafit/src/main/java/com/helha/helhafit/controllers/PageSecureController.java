package com.helha.helhafit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page-secure")
public class PageSecureController {


    @GetMapping
    public String getPageSecureBySpringSecurity(Model model){
        return "page-secure";
    }
}
