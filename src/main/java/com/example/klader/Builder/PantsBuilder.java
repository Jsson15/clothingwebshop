package com.example.klader.Builder;

import com.example.klader.Clothing.Pants;

public class PantsBuilder implements ClothingBuilder {
    private Pants clothing = new Pants();

    public PantsBuilder() {
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
    public Pants build() {
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
    public Pants getClothing() {
        return this.clothing;
    }
}

