package com.example.klader.Clothing;


public class Skirt extends ClothingItem {

    private String waist;
    private String pattern;

    public Skirt() {
        setPrice(249);
        setName("Skirt");
    }

    @Override
    public void getDetails() {
        System.out.println("Skirt");
        System.out.println("Material: " + getMaterial() + "\n" +
                "Size: " + getSize() + "\n" +
                "Color: " + getColor() + "\n" +
                "Waist : " + getWaist() + "\n" +
                "Pattern: " + getPattern() + "\n" +
                "Price: " + getPrice() + ":-\n");
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}

