package com.example.klader;

public class ClothingItem {
    private String name;
    private String type;
    private String size;
    private String material;
    private String color;
    private String fit;
    private String length;
    private String pattern;
    private String specific;

    public ClothingItem(String name, String type, String size, String material, String color, String fit, String length, String pattern, String specific) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = length;
        this.pattern = pattern;
        this.specific = specific;
    }

    // Method to create a ClothingItem object from a ClothingItemBuilder
    public static ClothingItem buildFromBuilder(ClothingItemBuilder builder) {
        return new ClothingItem(builder.name, builder.type, builder.size, builder.material, builder.color, builder.fit, builder.length, builder.pattern, builder.specific);
    }

    @Override
    public String toString() {
        return "Klädesplagg: " + type + ", Storlek: " + size + ", Material: " + material + ", Färg: " + color + ", Passform: " + fit + ", Längd: " + length + ", Mönster: " + pattern + ", Specifik: " + specific;
    }
}
