package com.example.demo.controller;

import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "main")
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "homepage";
    }
}
