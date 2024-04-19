package com.example.klader;

public class ClothingItemBuilder {
    String name;
    String type;
    String size;
    String material;
    String color;
    String fit;
    String length;
    String pattern;
    String specific;

    public ClothingItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClothingItemBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ClothingItemBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public ClothingItemBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public ClothingItemBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public ClothingItemBuilder setFit(String fit) {
        this.fit = fit;
        return this;
    }

    public ClothingItemBuilder setLength(String length) {
        this.length = length;
        return this;
    }

    public ClothingItemBuilder setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public ClothingItemBuilder setSpecific(String specific) {
        this.specific = specific;
        return this;
    }

    public ClothingItem build() {
        return ClothingItem.buildFromBuilder(this);
    }
}
