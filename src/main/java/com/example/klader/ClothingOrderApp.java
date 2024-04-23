package com.example.klader;

import com.example.klader.Command.OrderCommand;
import java.util.Scanner;

public class ClothingOrderApp {
    private static Scanner scanner = new Scanner(System.in);
    private static EventManager eventManager = new EventManager();

    public static void main(String[] args) {
        // Skapa och registrera CEO som observer
        CEO ceo = new CEO();
        ceo.setId("CEO1");  // Exempel ID
        ceo.setName("John Doe");  // Exempelnamn
        eventManager.subscribe(ceo);

        System.out.println("Welcome to the Clothing Order App!");
        while (true) {
            System.out.println("Which type of clothing do you want to order? (Pants, TShirt, Skirt, Exit)");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("Exit")) break;

            ClothingItem item = handleOrder(type);
            if (item != null) {
                printReceipt(item);  // Skriver ut kvitto efter att beställningen är klar
                // Notifiera CEO via EventManager när en order är klar
                eventManager.notifyObservers("Order for " + item.getClass().getSimpleName() + " completed. Details: Size=" + item.getSize() + ", Material=" + item.getMaterial() + ", Color=" + item.getColor());
            } else {
                System.out.println("Invalid clothing type.");
            }
        }
    }

    private static ClothingItem handleOrder(String type) {
        System.out.println("Enter size (Small, Medium, Large):");
        String size = scanner.nextLine();
        System.out.println("Enter material (specific options based on type):");
        String material = scanner.nextLine();
        System.out.println("Enter color (specific options based on your preference):");
        String color = scanner.nextLine();

        String fit = "", length = "", sleeves = "", neck = "", waistline = "", pattern = "";
        switch (type.toLowerCase()) {
            case "pants":
                System.out.println("Enter fit (Slim, Regular):");
                fit = scanner.nextLine();
                System.out.println("Enter length (Short, Regular, Long):");
                length = scanner.nextLine();
                break;
            case "tshirt":
                System.out.println("Enter sleeves (Short, Long):");
                sleeves = scanner.nextLine();
                System.out.println("Enter neck (V-neck, Crew neck):");
                neck = scanner.nextLine();
                break;
            case "skirt":
                System.out.println("Enter waistline (High, Low):");
                waistline = scanner.nextLine();
                System.out.println("Enter pattern (Solid, Striped):");
                pattern = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid clothing type.");
                return null;
        }

        OrderCommand orderCommand = new OrderCommand(type, size, material, color, fit, length, sleeves, neck, waistline, pattern, eventManager);
        return orderCommand.execute();
    }

    private static void printReceipt(ClothingItem item) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Item Ordered: " + item.getClass().getSimpleName());
        System.out.println("Size: " + item.getSize());
        System.out.println("Material: " + item.getMaterial());
        System.out.println("Color: " + item.getColor());
        if (item instanceof Pants) {
            Pants pants = (Pants) item;
            System.out.println("Fit: " + pants.getFit());
            System.out.println("Length: " + pants.getLength());
        } else if (item instanceof TShirt) {
            TShirt tshirt = (TShirt) item;
            System.out.println("Sleeves: " + tshirt.getSleeves());
            System.out.println("Neck: " + tshirt.getNeck());
        } else if (item instanceof Skirt) {
            Skirt skirt = (Skirt) item;
            System.out.println("Waistline: " + skirt.getWaistline());
            System.out.println("Pattern: " + skirt.getPattern());
        }
        System.out.println("----------------\n");
    }
}
