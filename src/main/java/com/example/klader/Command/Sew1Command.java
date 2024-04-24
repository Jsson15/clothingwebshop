package com.example.klader.Command;

import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Clothing.Pants;
import com.example.klader.Clothing.Skirt;
import com.example.klader.Clothing.TShirt;

public class Sew1Command implements Command{
    @Override
    public ClothingItem decorate(ClothingItem clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaist("High waist");
        } else if (clothing instanceof Pants) {
            ((Pants) clothing).setFit("Slim fit");
        } else {
            ((TShirt) clothing).setNeck("V-neck");
        }
        System.out.println("Details for "+clothing.getClass().getSimpleName()+" has been sewn");
        return clothing;
    }
}
