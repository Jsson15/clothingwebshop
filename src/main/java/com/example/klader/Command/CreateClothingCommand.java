package com.example.klader.Command;

import com.example.klader.ClothingItem;

public class CreateClothingCommand implements Command {
    private ClothingItem item;

    public CreateClothingCommand(ClothingItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.println("Creating " + item.getClass().getSimpleName() + " with size " + item.getSize() + " and color " + item.getColor());
    }
}
