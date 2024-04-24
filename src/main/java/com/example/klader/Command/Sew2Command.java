package com.example.klader.Command;

import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Clothing.Pants;
import com.example.klader.Clothing.Skirt;
import com.example.klader.Clothing.TShirt;

public class Sew2Command implements Command{
    @Override
    public ClothingItem decorate(ClothingItem clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setWaist("Low waist");
        } else if (clothing instanceof Pants) {
            ((Pants) clothing).setFit("Regular fit");
        } else {
            ((TShirt) clothing).setNeck("U-neck");
        }
        System.out.println("Details for "+clothing.getClass().getSimpleName()+" has been sewn");
        return clothing;
    }
}
