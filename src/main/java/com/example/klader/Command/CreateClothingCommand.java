package com.example.klader.Command;

import com.example.klader.ClothingItem;

public class CreateClothingCommand {
    private ClothingItem item;

    public CreateClothingCommand(ClothingItem item) {
        this.item = item;
    }


    public void execute() {
        System.out.println("Creating " + item.getClass().getSimpleName() + " with size " + item.getSize() + " and color " + item.getColor());
    }
}
