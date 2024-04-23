package com.example.klader.Command;


import com.example.klader.ClothingItem;
public class SetColorCommand {
    private String color;

    public SetColorCommand(String color) {
        this.color = color;
    }


    public void execute(ClothingItem item) {
        item.setColor(color);
    }
}
