package com.example.klader;

public class Pants extends ClothingItem {
    private String fit;
    private String length;

    public Pants() {}

    // getters and setters for specific attributes
    public String getFit() { return fit; }
    public void setFit(String fit) { this.fit = fit; }

    public String getLength() { return length; }
    public void setLength(String length) { this.length = length; }
}
