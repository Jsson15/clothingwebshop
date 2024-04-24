package com.example.klader.Clothing;

import com.example.klader.Business.BusinessObject;

public abstract class ClothingItem extends BusinessObject {

    private double price;
    private String size; //M & L
    private String material; //Jeans & Leather // Siden & Cotton for TShirt
    private String color; //Blue & Black // Grey & White for TShirt

    public ClothingItem() {
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

    public void getDetails(){
    }

}
