package com.example.klader;

public class TShirt extends ClothingItem {
    private String sleeves;
    private String neck;

    public TShirt() {
        super(); // Anropa konstruktorn för basen
    }

    // Getters and setters för specifika attribut
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
