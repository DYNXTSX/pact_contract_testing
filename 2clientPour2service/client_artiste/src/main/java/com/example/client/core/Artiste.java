package com.example.client.core;

public class Artiste {
    private String name;
    private Integer age;
    private Integer noOfMusic;

    public Artiste (){}

    public Artiste(String name, Integer age, Integer noOfMusic){
        this.name = name;
        this.age = age;
        this.noOfMusic = noOfMusic;
    }

    public Integer getAge() {
        return age;
    }
    public Integer getNoOfMusic() {
        return noOfMusic;
    }
    public String getName() {
        return name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNoOfMusic(Integer noOfMusic) {
        this.noOfMusic = noOfMusic;
    }
}
