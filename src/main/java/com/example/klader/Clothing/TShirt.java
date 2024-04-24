package com.example.klader.Clothing;

public class TShirt extends ClothingItem {

    private String neck;
    private String sleeves;

    public TShirt() {
        setPrice(599);
        setName("TShirt");
    }

    @Override
    public void getDetails() {
        System.out.println("T-shirt");
        System.out.println("Material: " + getMaterial() + "\n" +
                "Size: " + getSize() + "\n" +
                "Color: " + getColor() + "\n" +
                "Neck : " + getNeck() + "\n" +
                "Sleeves: " + getSleeves() + "\n" +
                "Price: " + getPrice() + ":-\n");
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
}
