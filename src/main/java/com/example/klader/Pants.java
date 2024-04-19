package com.example.klader;

// Pants.java
public class Pants {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;
    private String fit;
    private String length;

    public Pants(String id, String name, String size, double price, String material, String color, String fit, String length) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = this.length;
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

    public String getFit() {

        return fit;
    }

    public void setFit(String fit) {

        this.fit = fit;
    }

    public String getLength() {

        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }


    // Metod för att utföra tillverkningsprocessen för byxor
    public void manufacture() {
        System.out.println("1. Anger material: " + material);
        System.out.println("2. Väljer storlek: " + size);
        System.out.println("3. Färgar plagget: " + color);
        System.out.println("4. Syr till önskad passform: " + fit);
        System.out.println("5. Klipper önskad längd: " + length);
    }
    @Override
    public String toString() {
        return name + ": Storlek: " + size + ", Material: " + material + ", Färg: " + color + ", Passform: " + fit + ", Längd: " + length;
    }

}




