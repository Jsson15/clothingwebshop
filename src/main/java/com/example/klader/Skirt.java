package com.example.klader;


public class Skirt extends ClothingItem {
    private String waistline;
    private String pattern;

    public Skirt() {
        super(); // Anropa konstruktorn för basen
    }

    // Getters and setters för specifika attribut
    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
