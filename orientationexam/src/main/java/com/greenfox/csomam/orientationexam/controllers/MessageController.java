package com.greenfox.csomam.orientationexam.controllers;

import com.greenfox.csomam.orientationexam.modules.JsonResponse;
import com.greenfox.csomam.orientationexam.modules.LicencePlate;
import com.greenfox.csomam.orientationexam.repositories.LicencePlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    LicencePlateRepo licencePlateRepo;

    @PostMapping("/api/search/{brand}")
    @CrossOrigin("*")
    public ResponseEntity receiveMessage(@PathVariable String brand) {
        if (licencePlateRepo.findBrand(brand).size() == 0) {
            return new ResponseEntity(new JsonResponse("invalid brand"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity( new JsonResponse("ok", licencePlateRepo.findBrand(brand)), HttpStatus.OK);
        }
    }
}
