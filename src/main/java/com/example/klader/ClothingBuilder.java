package com.example.klader;


public abstract class ClothingBuilder {
    protected ClothingItem item;

    public ClothingBuilder setMaterial(String material) {
        item.setMaterial(material);
        return this;
    }

    public ClothingBuilder setSize(String size) {
        item.setSize(size);
        return this;
    }

    public ClothingBuilder setColor(String color) {
        item.setColor(color);
        return this;
    }

    public abstract ClothingItem build();
}
