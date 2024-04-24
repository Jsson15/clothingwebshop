package com.example.klader.Builder;

import com.example.klader.Clothing.Skirt;

public class SkirtBuilder implements ClothingBuilder {
    private Skirt clothing = new Skirt();


    public SkirtBuilder() {
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
    public Skirt build() {
        if (!clothing.getSize().equalsIgnoreCase("M") && !clothing.getSize().equalsIgnoreCase("L")) {
            throw new RuntimeException("Missing correct size");
        } else if (!clothing.getMaterial().equalsIgnoreCase("Jeans") && !clothing.getMaterial().equalsIgnoreCase("Leather")) {
            throw new RuntimeException("Missing correct material");
        } else if (!clothing.getColor().equalsIgnoreCase("Black") && !clothing.getColor().equalsIgnoreCase("Blue")) {
            throw new RuntimeException("Missing correct color");
        } else {
            getClothing().setId(idCount.incrementAndGet());
            return clothing;
        }
    }

    @Override
    public Skirt getClothing() {
        return this.clothing;
    }
}
