package com.example.retailer.core;

public class Order {
    private String customer;
    private Double total;
    private Integer noOfMusic;

    public Order(String customer, Double total, Integer noOfMusic) {
        this.customer = customer;
        this.total = total;
        this.noOfMusic = noOfMusic;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer noOfMusic() {
        return noOfMusic;
    }

    public void noOfMusic(Integer noOfMusic) {
        this.noOfMusic = noOfMusic;
    }
}
