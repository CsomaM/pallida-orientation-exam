package com.greenfox.csomam.orientationexam.controllers;

import com.greenfox.csomam.orientationexam.repositories.LicencePlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    LicencePlateRepo licencePlateRepo;

    @RequestMapping({"", "/", "/index"})
    public String mainPage(Model model) {
        model.addAttribute("platenumbers", licencePlateRepo.findAll());
        return "index";
    }
}
