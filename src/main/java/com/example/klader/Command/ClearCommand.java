package com.example.klader.Command;

import com.example.klader.ClothingItem;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Concrete command for clearing orders
public class ClearCommand implements Command {
    private AtomicInteger totalClothesToManufacture;
    private List<ClothingItem> clothesToManufacture;
    private TextArea orderDetailsArea;

    public ClearCommand(AtomicInteger totalClothesToManufacture, List<ClothingItem> clothesToManufacture, TextArea orderDetailsArea) {
        this.totalClothesToManufacture = totalClothesToManufacture;
        this.clothesToManufacture = clothesToManufacture;
        this.orderDetailsArea = orderDetailsArea;
    }

    @Override
    public void execute() {
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
    }

    // Method to generate receipt
    private void generateReceipt(List<ClothingItem> clothesToManufacture) {
        System.out.println("KVITTO:");
        for (ClothingItem item : clothesToManufacture) {
            System.out.println("- " + item.toString());
        }
    }
}
