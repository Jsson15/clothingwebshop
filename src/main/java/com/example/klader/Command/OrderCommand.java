package com.example.klader.Command;

import com.example.klader.ClothingItem;
import com.example.klader.ClothingItemBuilder;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Concrete command for placing an order
public class OrderCommand implements Command {
    private AtomicInteger totalClothesToManufacture;
    private List<ClothingItem> clothesToManufacture;
    private TextField nameField;
    private ChoiceBox<String> clothesTypeChoiceBox;
    private ChoiceBox<String> sizeChoiceBox;
    private TextField materialField;
    private TextField colorField;
    private ChoiceBox<String> fitChoiceBox;
    private ChoiceBox<String> lengthChoiceBox;
    private ChoiceBox<String> patternChoiceBox;
    private TextField specificField;
    private TextArea orderDetailsArea;

    public OrderCommand(AtomicInteger totalClothesToManufacture, List<ClothingItem> clothesToManufacture, TextField nameField, ChoiceBox<String> clothesTypeChoiceBox, ChoiceBox<String> sizeChoiceBox, TextField materialField, TextField colorField, ChoiceBox<String> fitChoiceBox, ChoiceBox<String> lengthChoiceBox, ChoiceBox<String> patternChoiceBox, TextField specificField, TextArea orderDetailsArea) {
        this.totalClothesToManufacture = totalClothesToManufacture;
        this.clothesToManufacture = clothesToManufacture;
        this.nameField = nameField;
        this.clothesTypeChoiceBox = clothesTypeChoiceBox;
        this.sizeChoiceBox = sizeChoiceBox;
        this.materialField = materialField;
        this.colorField = colorField;
        this.fitChoiceBox = fitChoiceBox;
        this.lengthChoiceBox = lengthChoiceBox;
        this.patternChoiceBox = patternChoiceBox;
        this.specificField = specificField;
        this.orderDetailsArea = orderDetailsArea;
    }

    @Override
    public void execute() {
        totalClothesToManufacture.incrementAndGet();

        ClothingItem item = new ClothingItemBuilder()
                .setName(nameField.getText())
                .setType(clothesTypeChoiceBox.getValue())
                .setSize(sizeChoiceBox.getValue())
                .setMaterial(materialField.getText())
                .setColor(colorField.getText())
                .setFit(fitChoiceBox.getValue())
                .setLength(lengthChoiceBox.getValue())
                .setPattern(patternChoiceBox.getValue())
                .setSpecific(specificField.getText())
                .build();

        clothesToManufacture.add(item);

        // Update order details in TextArea
        orderDetailsArea.appendText("Beställning " + totalClothesToManufacture + ": " + item.toString() + "\n");
        System.out.println("Beställning av " + clothesTypeChoiceBox.getValue() + " lagd.");
    }
}

