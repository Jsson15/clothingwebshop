package com.example.klader.Command;

import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Clothing.Pants;
import com.example.klader.Clothing.Skirt;
import com.example.klader.Clothing.TShirt;

public class Sew3Command implements Command {
    @Override
    public ClothingItem decorate(ClothingItem clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaist("Mid on");
        } else if (clothing instanceof Pants) {
            ((Pants) clothing).setFit("Loose fit");
        } else {
            ((TShirt) clothing).setNeck("Polo");
        }
        System.out.println("Details for " + clothing.getClass().getSimpleName() + " has been sewn");
        return clothing;
    }
}

