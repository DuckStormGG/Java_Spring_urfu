package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenresController {
    @GetMapping("/genres")
    public String mainPage(Model model){
        return "genres/index";
    }
}
