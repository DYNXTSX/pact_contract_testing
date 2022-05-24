package com.example.retailer.core;

import org.springframework.stereotype.Service;

@Service
public class FournisseurService {

    public Music getMusicDetails(String musicId){
        return new Music("DANCE MONKEY", "TONES AND I", 2019);
    }

    public Artiste getArtisteDetails(String artisteId){
        return new Artiste("XXXTENTACION", 21, 1);
    }
}


