package com.greenfox.csomam.orientationexam.controllers;

import com.greenfox.csomam.orientationexam.modules.LicencePlate;
import com.greenfox.csomam.orientationexam.repositories.LicencePlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.regex.Pattern;

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

    @RequestMapping("search/{type}")
    public String mainPageWithType(@PathVariable String type, Model model) {
        if (type.equals("police")) {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findLicenceType("RB"));
        } else if (type.equals("diplomat")) {
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
        if (licencePlate.getPlate().matches("[a-zA-Z0-9-]*") && licencePlate.getPlate().length() < 8) {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("platenumbers", licencePlateRepo.findLicencePlate(licencePlate.getPlate()));
        } else {
            model.addAttribute("searchedplatenumber", new LicencePlate());
            model.addAttribute("errormessage", "Sorry, the submitted licence plate is not valid");
        }
        return "index";
    }
}
