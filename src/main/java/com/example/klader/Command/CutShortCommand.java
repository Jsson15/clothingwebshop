package com.example.klader.Command;

import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Clothing.Pants;
import com.example.klader.Clothing.Skirt;
import com.example.klader.Clothing.TShirt;

public class CutShortCommand implements Command {


    @Override
    public ClothingItem decorate(ClothingItem clothing) {
        if (clothing instanceof Skirt) {
            ((Skirt) clothing).setPattern("Short");
        } else if (clothing instanceof Pants) {
            ((Pants) clothing).setLength("Short");
        } else {
            ((TShirt) clothing).setSleeves("Short");
        }
        System.out.println("Details for "+clothing.getClass().getSimpleName()+" has been cut");
        return clothing;
    }
}

