package com.example.retailer.core;

import org.springframework.stereotype.Service;

@Service
public class RetailerService {

    public Music getMusicDetails(String itemId) {
        return new Music("PerfectMusic", "A1", 2022);
    }

    public Order getOrderDetails(String orderId) {
        return new Order("Spotify", 2.99, 1);
    }
}
