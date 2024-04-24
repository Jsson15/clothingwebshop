package com.example.klader.Builder;


import com.example.klader.Clothing.ClothingItem;

import java.util.concurrent.atomic.AtomicInteger;

public interface ClothingBuilder {
    AtomicInteger idCount = new AtomicInteger(0);

    default ClothingBuilder addSize(String size) {
        return null;
    }


    default ClothingBuilder addMaterial(String material) {
        return null;
    }

    default ClothingBuilder addColor(String color) {
        return null;
    }


    default ClothingItem build() {
        return null;
    }

    default void setClothing(ClothingItem clothing) {
    }

    default ClothingItem getClothing() {
        return null;
    }


}

