package com.greenfox.csomam.orientationexam.controllers;

import com.greenfox.csomam.orientationexam.modules.LicencePlate;
import com.greenfox.csomam.orientationexam.repositories.LicencePlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
public class MainController {

    @Autowired
    LicencePlateRepo licencePlateRepo;

    @RequestMapping({"", "/", "/index", })
    public String mainPage( Model model) {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findAll());
        return "index";
    }

    @RequestMapping("/index/{type}")
    public String mainPageWithType(@PathVariable String type, Model model) {
        if (type.equals("RB")) {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findLicenceType("RB"));
        } else if (type.equals("DT")) {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findLicenceType("DT"));
        } else {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findBrand(type));
        }
        return "index";
    }



    @PostMapping("/search")
    public String add (@ModelAttribute LicencePlate licencePlate, Model model){
        model.addAttribute("searchedplatenumber", new LicencePlate());
        model.addAttribute("platenumbers", licencePlateRepo.findLicencePlate(licencePlate.getPlate()));
        return "index";
    }

}
