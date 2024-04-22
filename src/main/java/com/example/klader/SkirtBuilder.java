package com.example.klader;

public class SkirtBuilder extends ClothingBuilder {
    public SkirtBuilder() {
        this.item = new Skirt();  // Skapar en ny instans av Skirt
    }

    // Steg 1: Anger material på plagget
    public SkirtBuilder setMaterial(String material) {
        super.setMaterial(material);  // Anropar setMaterial i bas-klassen
        return this;
    }

    // Steg 2: Väljer storlek på materialark
    public SkirtBuilder setSize(String size) {
        super.setSize(size);  // Anropar setSize i bas-klassen
        return this;
    }

    // Steg 3: Färgar plagget
    public SkirtBuilder setColor(String color) {
        super.setColor(color);  // Anropar setColor i bas-klassen
        return this;
    }

    // Steg 4: Syr till önskad midja
    public SkirtBuilder setWaistline(String waistline) {
        ((Skirt) item).setWaistline(waistline);
        return this;
    }

    // Steg 5: Syr/klipper till önskat mönster
    public SkirtBuilder setPattern(String pattern) {
        ((Skirt) item).setPattern(pattern);
        return this;
    }

    @Override
    public Skirt build() {
        return (Skirt) item;  // Returnerar den fullständigt byggda Skirt-instansen
    }
}
