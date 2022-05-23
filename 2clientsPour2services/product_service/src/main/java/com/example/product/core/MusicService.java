package com.example.product.core;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MusicService {
    public Music getMusicDetail() {
        return new RestTemplate().getForObject("http://localhost:8088/music/1009", Music.class);
    }
}
