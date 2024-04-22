package com.example.klader;

public class TShirtBuilder extends ClothingBuilder {
    public TShirtBuilder() {
        this.item = new TShirt();  // Skapar en ny instans av TShirt
    }

    // Steg 1: Anger material på plagget
    public TShirtBuilder setMaterial(String material) {
        super.setMaterial(material);  // Anropar setMaterial i bas-klassen
        return this;
    }

    // Steg 2: Väljer storlek på materialark
    public TShirtBuilder setSize(String size) {
        super.setSize(size);  // Anropar setSize i bas-klassen
        return this;
    }

    // Steg 3: Färgar plagget
    public TShirtBuilder setColor(String color) {
        super.setColor(color);  // Anropar setColor i bas-klassen
        return this;
    }

    // Steg 4: Syr till önskad nacke
    public TShirtBuilder setNeck(String neck) {
        ((TShirt) item).setNeck(neck);
        return this;
    }

    // Steg 5: Klipper önskad ärmlängd
    public TShirtBuilder setSleeves(String sleeves) {
        ((TShirt) item).setSleeves(sleeves);
        return this;
    }

    @Override
    public TShirt build() {
        return (TShirt) item;  // Returnerar den fullständigt byggda TShirt-instansen
    }
}
