package com.example.klader;

// Skirt.java
public class Skirt {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;
    private String waistline;
    private String pattern;

    public Skirt(String id, String name, String size, double price, String material, String color, String waistline, String pattern) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.waistline = waistline;
        this.pattern = pattern;
    }

    // Getters och setters för alla attribut
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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


    // Metod för att utföra tillverkningsprocessen för kjol
    public void manufacture() {
        System.out.println("1. Anger material: " + material);
        System.out.println("2. Väljer storlek: " + size);
        System.out.println("3. Färgar plagget: " + color);
        System.out.println("4. Syr till önskad midja: " + waistline);
        System.out.println("5. Syr/klipper till önskat mönster: " + pattern);
    }

}
