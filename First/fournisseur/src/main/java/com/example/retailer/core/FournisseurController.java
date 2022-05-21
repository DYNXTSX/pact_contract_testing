package com.example.retailer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/music/{id}")
    public Music getMusicDetails(@PathVariable(value = "id") String musicId) {
        return fournisseurService.getMusicDetails(musicId);
    }
}
