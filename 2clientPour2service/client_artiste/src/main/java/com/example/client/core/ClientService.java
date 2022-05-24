package com.example.client.core;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
    public Artiste getArtisteDetail(){
        return new RestTemplate().getForObject("http://localhost:8088/artiste/2", Music.class);
    }
}
