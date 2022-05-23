package com.example.client.core;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
    public Music getMusicDetail(){
        return new RestTemplate().getForObject("http://localhost:8088/music/17", Music.class);
    }
}
