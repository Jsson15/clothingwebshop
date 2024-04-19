package com.example.klader;


// TShirt.java
public class TShirt {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;
    private String sleeves;
    private String neck;

    public TShirt(String id, String name, String size, double price, String material, String color, String sleeves) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.sleeves = sleeves;
        this.neck = neck;
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

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }


    // Metod för att utföra tillverkningsprocessen för T-shirt
    public void manufacture() {
        System.out.println("1. Anger material: " + material);
        System.out.println("2. Väljer storlek: " + size);
        System.out.println("3. Färgar plagget: " + color);
        System.out.println("4. Syr till önskad nacke: " + neck);
        System.out.println("5. Klipper önskad ärmlängd: " + sleeves);
    }
}
