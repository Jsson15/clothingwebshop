package com.example.klader.Command;

import com.example.klader.ClothingItem;
import com.example.klader.TShirtBuilder;
import com.example.klader.PantsBuilder;
import com.example.klader.SkirtBuilder;
import com.example.klader.EventManager;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderCommand {
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
    private EventManager eventManager;  // Observer management

    public OrderCommand(AtomicInteger totalClothesToManufacture, List<ClothingItem> clothesToManufacture, TextField nameField, ChoiceBox<String> clothesTypeChoiceBox, ChoiceBox<String> sizeChoiceBox, TextField materialField, TextField colorField, ChoiceBox<String> fitChoiceBox, ChoiceBox<String> lengthChoiceBox, ChoiceBox<String> patternChoiceBox, TextField specificField, TextArea orderDetailsArea, EventManager eventManager) {
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
        this.eventManager = eventManager;
    }


    public void execute() {
        totalClothesToManufacture.incrementAndGet();
        ClothingItem item = createClothingItem();
        clothesToManufacture.add(item);

        // Notify CEO that a new garment is being manufactured
        eventManager.notifyObservers("Plagg tillverkas: " + item.toString());

        // Update order details in TextArea
        orderDetailsArea.appendText("Order " + totalClothesToManufacture.get() + ": " + item.toString() + "\n");

        // Print receipt in the console
        printReceipt(item);

        // Notify CEO that the garment is ready for delivery
        eventManager.notifyObservers("Plagg klar: " + item.toString());

        System.out.println("Order for " + clothesTypeChoiceBox.getValue() + " placed.");
    }

    private ClothingItem createClothingItem() {
        String clothingType = clothesTypeChoiceBox.getValue();
        ClothingItem item = null;
        switch (clothingType) {
            case "TShirt":
                item = new TShirtBuilder()
                        .setMaterial(materialField.getText())
                        .setSize(sizeChoiceBox.getValue())
                        .setColor(colorField.getText())
                        .setSleeves(specificField.getText()) // Assume specificField for sleeves
                        .setNeck(patternChoiceBox.getValue()) // Assume patternChoiceBox for neck type
                        .build();
                break;
            case "Pants":
                item = new PantsBuilder()
                        .setMaterial(materialField.getText())
                        .setSize(sizeChoiceBox.getValue())
                        .setColor(colorField.getText())
                        .setFit(fitChoiceBox.getValue())
                        .setLength(lengthChoiceBox.getValue())
                        .build();
                break;
            case "Skirt":
                item = new SkirtBuilder()
                        .setMaterial(materialField.getText())
                        .setSize(sizeChoiceBox.getValue())
                        .setColor(colorField.getText())
                        .setWaistline(fitChoiceBox.getValue()) // Assume fitChoiceBox for waistline
                        .setPattern(patternChoiceBox.getValue())
                        .build();
                break;
        }
        return item;
    }

    private void printReceipt(ClothingItem item) {
        System.out.println("Receipt for order #" + totalClothesToManufacture.get());
        System.out.println("Name: " + item.getName());
        System.out.println("Size: " + item.getSize());
        System.out.println("Price: $" + item.getPrice());
        System.out.println("Material: " + item.getMaterial());
        System.out.println("Color: " + item.getColor());
        System.out.println("----------");
    }
}
