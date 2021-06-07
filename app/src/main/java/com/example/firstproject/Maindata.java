package com.example.firstproject;

public class Maindata {

    int CSImage;
    String name;

    public Maindata(String name, int CSImage) {
        this.name = name;
        this.CSImage = CSImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCSImage() {
        return CSImage;
    }

    public void setCSImage(int CSImage) {
        this.CSImage = CSImage;
    }

}