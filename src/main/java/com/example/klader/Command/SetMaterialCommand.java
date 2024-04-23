package com.example.klader.Command;

import com.example.klader.ClothingItem;

public class SetMaterialCommand {
    private String material;

    public SetMaterialCommand(String material) {
        this.material = material;
    }


    public void execute(ClothingItem item) {
        item.setMaterial(material);
    }
}
