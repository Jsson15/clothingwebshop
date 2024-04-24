package com.example.klader.Business;

import com.example.klader.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends BusinessObject implements PropertyChangeListener {

    private static CEO ceo;

    private CEO() {
    }

    public static CEO getInstance() {
        if (ceo == null) {
            ceo = new CEO();
            ceo.setName("Henric Johansson");
            ceo.setId(1);
        }
        return ceo;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.print("To CEO: ");
        if (evt.getPropertyName().equals("ClothingBuilder")) {
            System.out.println("Producing " + evt.getNewValue());
        } else if (evt.getPropertyName().equals("DecoratingClothes")) {
            System.out.println(evt.getNewValue() + " ready");
        }
    }
}
