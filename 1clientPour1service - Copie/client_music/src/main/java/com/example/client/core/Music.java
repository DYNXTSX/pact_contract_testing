package com.example.client.core;

public class Music {
    private String name;
    private String artiste;
    private Integer year;

    public Music(){}

    public Music(String name, String artiste, Integer year){
        this.name = name;
        this.artiste = artiste;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtiste() {
        return artiste;
    }
    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}
