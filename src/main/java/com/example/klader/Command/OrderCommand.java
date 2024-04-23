package com.example.klader.Command;

import com.example.klader.*;
import com.example.klader.EventManager;

public class OrderCommand {
    private String type, size, material, color, fit, length, sleeves, neck, waistline, pattern;
    private EventManager eventManager;

    public OrderCommand(String type, String size, String material, String color, String fit, String length, String sleeves, String neck, String waistline, String pattern, EventManager eventManager) {
        this.type = type;
        this.size = size;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = length;
        this.sleeves = sleeves;
        this.neck = neck;
        this.waistline = waistline;
        this.pattern = pattern;
        this.eventManager = eventManager;
    }

    public ClothingItem execute() {
        ClothingItem item = null;
        switch (type.toLowerCase()) {
            case "pants":
                item = new PantsBuilder()
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setFit(fit)
                        .setLength(length)
                        .build();
                break;
            case "tshirt":
                item = new TShirtBuilder()
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setSleeves(sleeves)
                        .setNeck(neck)
                        .build();
                break;
            case "skirt":
                item = new SkirtBuilder()
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setWaistline(waistline)
                        .setPattern(pattern)
                        .build();
                break;
        }
        if (item != null) {
            eventManager.notifyObservers("New " + item.getClass().getSimpleName() + " created: " + item);
        }
        return item;
    }
}
