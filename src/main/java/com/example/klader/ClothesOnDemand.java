package com.example.klader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClothesOnDemand extends Application {
    private AtomicInteger totalClothesToManufacture = new AtomicInteger(0);
    private List<ClothingItem> clothesToManufacture = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Namn:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        Label clothesTypeLabel = new Label("Välj klädesplaggstyp:");
        ChoiceBox<String> clothesTypeChoiceBox = new ChoiceBox<>();
        clothesTypeChoiceBox.getItems().addAll("Byxor", "Tröjor", "Kjolar");
        gridPane.add(clothesTypeLabel, 0, 1);
        gridPane.add(clothesTypeChoiceBox, 1, 1);

        Label sizeLabel = new Label("Storlek:");
        ChoiceBox<String> sizeChoiceBox = new ChoiceBox<>();
        sizeChoiceBox.getItems().addAll("Small", "Medium", "Large");
        gridPane.add(sizeLabel, 0, 2);
        gridPane.add(sizeChoiceBox, 1, 2);

        Label materialLabel = new Label("Material:");
        TextField materialField = new TextField();
        gridPane.add(materialLabel, 0, 3);
        gridPane.add(materialField, 1, 3);

        Label colorLabel = new Label("Färg:");
        TextField colorField = new TextField();
        gridPane.add(colorLabel, 0, 4);
        gridPane.add(colorField, 1, 4);

        Label fitLabel = new Label("Passform:");
        ChoiceBox<String> fitChoiceBox = new ChoiceBox<>();
        fitChoiceBox.getItems().addAll("Slim fit", "Regular fit", "Loose fit");
        gridPane.add(fitLabel, 0, 5);
        gridPane.add(fitChoiceBox, 1, 5);

        Label lengthLabel = new Label("Längd:");
        ChoiceBox<String> lengthChoiceBox = new ChoiceBox<>();
        lengthChoiceBox.getItems().addAll("Short", "Regular", "Long");
        gridPane.add(lengthLabel, 0, 6);
        gridPane.add(lengthChoiceBox, 1, 6);

        Label patternLabel = new Label("Mönster:");
        ChoiceBox<String> patternChoiceBox = new ChoiceBox<>();
        patternChoiceBox.getItems().addAll("Solid", "Striped", "Checkered");
        gridPane.add(patternLabel, 0, 7);
        gridPane.add(patternChoiceBox, 1, 7);

        Label specificLabel = new Label("Klädattribut:");
        TextField specificField = new TextField();
        gridPane.add(specificLabel, 0, 8);
        gridPane.add(specificField, 1, 8);

        sizeLabel.setVisible(false);
        sizeChoiceBox.setVisible(false);
        materialLabel.setVisible(false);
        materialField.setVisible(false);
        colorLabel.setVisible(false);
        colorField.setVisible(false);
        specificLabel.setVisible(false);
        specificField.setVisible(false);
        fitLabel.setVisible(false);
        fitChoiceBox.setVisible(false);
        lengthLabel.setVisible(false);
        lengthChoiceBox.setVisible(false);
        patternLabel.setVisible(false);
        patternChoiceBox.setVisible(false);

        clothesTypeChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                sizeChoiceBox.getSelectionModel().clearSelection();
                materialField.clear();
                colorField.clear();
                specificField.clear();

                sizeLabel.setVisible(true);
                sizeChoiceBox.setVisible(true);
                materialLabel.setVisible(true);
                materialField.setVisible(true);
                colorLabel.setVisible(true);
                colorField.setVisible(true);

                switch (newValue) {
                    case "Byxor":
                        fitLabel.setText("Passform:");
                        lengthLabel.setText("Längd:");
                        fitLabel.setVisible(true);
                        fitChoiceBox.setVisible(true);
                        lengthLabel.setVisible(true);
                        lengthChoiceBox.setVisible(true);
                        patternLabel.setVisible(false);
                        patternChoiceBox.setVisible(false);
                        specificLabel.setVisible(false);
                        specificField.setVisible(false);
                        break;
                    case "Tröjor":
                        specificLabel.setText("Nacke:");
                        lengthLabel.setText("Ärmlängd:");
                        specificLabel.setVisible(true);
                        specificField.setVisible(true);
                        fitLabel.setVisible(false);
                        fitChoiceBox.setVisible(false);
                        lengthLabel.setVisible(true);
                        lengthChoiceBox.setVisible(true);
                        patternLabel.setVisible(false);
                        patternChoiceBox.setVisible(false);
                        break;
                    case "Kjolar":
                        specificLabel.setText("Midja:");
                        patternLabel.setVisible(true);
                        patternChoiceBox.setVisible(true);
                        specificLabel.setVisible(true);
                        specificField.setVisible(true);
                        fitLabel.setVisible(false);
                        fitChoiceBox.setVisible(false);
                        lengthLabel.setVisible(false);
                        lengthChoiceBox.setVisible(false);
                        break;
                }
            } else {
                sizeLabel.setVisible(false);
                sizeChoiceBox.setVisible(false);
                materialLabel.setVisible(false);
                materialField.setVisible(false);
                colorLabel.setVisible(false);
                colorField.setVisible(false);
                specificLabel.setVisible(false);
                specificField.setVisible(false);
                fitLabel.setVisible(false);
                fitChoiceBox.setVisible(false);
                lengthLabel.setVisible(false);
                lengthChoiceBox.setVisible(false);
                patternLabel.setVisible(false);
                patternChoiceBox.setVisible(false);
            }
        });

        Button orderButton = new Button("Lägg beställning");
        gridPane.add(orderButton, 1, 9);
        GridPane.setValignment(orderButton, javafx.geometry.VPos.BOTTOM);

        Button klarButton = new Button("Klar");
        gridPane.add(klarButton, 1, 10);
        GridPane.setValignment(klarButton, javafx.geometry.VPos.BOTTOM);

        VBox root = new VBox();
        root.getChildren().addAll(gridPane);

        TextArea orderDetailsArea = new TextArea(); // Skapa en TextArea för att visa beställningsdetaljer
        orderDetailsArea.setEditable(false); // Gör den oredigerbar
        root.getChildren().add(orderDetailsArea); // Lägg till TextArea i layouten

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Clothes On Demand - Beställning");
        primaryStage.show();

        // "Lägg beställning"-knappens hantering
        orderButton.setOnAction(event -> {
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

            // Uppdatera beställningsdetaljer i TextArea
            orderDetailsArea.appendText("Beställning " + totalClothesToManufacture + ": " + item.toString() + "\n");
            System.out.println("Beställning av " + clothesTypeChoiceBox.getValue() + " lagd.");
        });

        // "Klar"-knappens hantering
        klarButton.setOnAction(event -> {
            if (totalClothesToManufacture.get() > 0) {
                System.out.println("Tillverkning påbörjas...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tillverkningen är klar.");
                generateReceipt(clothesToManufacture);
                totalClothesToManufacture.set(0);
                clothesToManufacture.clear();
            } else {
                System.out.println("Inga kläder att tillverka.");
            }
        });
    }

    // Metod för att generera kvitto
    private void generateReceipt(List<ClothingItem> clothesToManufacture) {
        System.out.println("KVITTO:");
        for (ClothingItem item : clothesToManufacture) {
            System.out.println("- " + item.toString());
        }
    }

}
