package com.example.klader.Builder;

import com.example.klader.Clothing.TShirt;

public class TShirtBuilder implements ClothingBuilder {
    private TShirt clothing = new TShirt();

    public TShirtBuilder() {
    }

    @Override
    public ClothingBuilder addSize(String size) {
        clothing.setSize(size);
        return this;
    }

    @Override
    public ClothingBuilder addMaterial(String material) {
        clothing.setMaterial(material);
        return this;
    }

    @Override
    public ClothingBuilder addColor(String color) {
        clothing.setColor(color);
        return this;
    }

    @Override
    public TShirt build() {
        if (!clothing.getSize().equalsIgnoreCase("M") && !clothing.getSize().equalsIgnoreCase("L")) {
            throw new RuntimeException("Missing correct size");
        } else if (!clothing.getMaterial().equalsIgnoreCase("Siden") && !clothing.getMaterial().equalsIgnoreCase("Cotton")) {
            throw new RuntimeException("Missing correct material");
        } else if (!clothing.getColor().equalsIgnoreCase("Grey") && !clothing.getColor().equalsIgnoreCase("White")) {
            throw new RuntimeException("Missing correct color");
        } else {
            getClothing().setId(idCount.incrementAndGet());
            return clothing;
        }
    }

    @Override
    public TShirt getClothing() {
        return this.clothing;
    }
}
