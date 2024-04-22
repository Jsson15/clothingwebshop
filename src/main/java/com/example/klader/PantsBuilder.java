package com.example.klader;

public class PantsBuilder extends ClothingBuilder {
    public PantsBuilder() {
        this.item = new Pants();  // Skapa en ny instans av Pants
    }

    // Steg 1: Anger material på plagget
    public PantsBuilder setMaterial(String material) {
        super.setMaterial(material);  // Anropar setMaterial i bas-klassen
        return this;
    }

    // Steg 2: Väljer storlek på materialark
    public PantsBuilder setSize(String size) {
        super.setSize(size);  // Anropar setSize i bas-klassen
        return this;
    }

    // Steg 3: Färgar plagget
    public PantsBuilder setColor(String color) {
        super.setColor(color);  // Anropar setColor i bas-klassen
        return this;
    }

    // Steg 4: Syr till önskad passform
    public PantsBuilder setFit(String fit) {
        ((Pants) item).setFit(fit);
        return this;
    }

    // Steg 5: Klipper önskad längd
    public PantsBuilder setLength(String length) {
        ((Pants) item).setLength(length);
        return this;
    }

    @Override
    public Pants build() {
        return (Pants) item;  // Returnerar den fullständigt byggda Pants-instansen
    }
}
