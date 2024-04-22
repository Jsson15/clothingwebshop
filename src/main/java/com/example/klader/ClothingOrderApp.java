package com.example.klader;


import java.util.Scanner;

public class ClothingOrderApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Clothing Order App!");
        while (true) {
            System.out.println("Which type of clothing do you want to order? (Pants, TShirt, Skirt, Exit)");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("Exit")) break;

            ClothingItem item = handleOrder(type);
            if (item != null) {
                printReceipt(item);  // Skriver ut kvitto efter att beställningen är klar
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
        System.out.println("Enter color (Red, Blue):");
        String color = scanner.nextLine();

        switch (type.toLowerCase()) {
            case "pants":
                System.out.println("Enter fit (Slim, Regular):");
                String fit = scanner.nextLine();
                System.out.println("Enter length (Short, Regular, Long):");
                String length = scanner.nextLine();
                return new PantsBuilder().setSize(size).setMaterial(material).setColor(color).setFit(fit).setLength(length).build();
            case "tshirt":
                System.out.println("Enter sleeves (Short, Long):");
                String sleeves = scanner.nextLine();
                System.out.println("Enter neck (V-neck, Crew neck):");
                String neck = scanner.nextLine();
                return new TShirtBuilder().setSize(size).setMaterial(material).setColor(color).setSleeves(sleeves).setNeck(neck).build();
            case "skirt":
                System.out.println("Enter waistline (High, Low):");
                String waistline = scanner.nextLine();
                System.out.println("Enter pattern (Solid, Striped):");
                String pattern = scanner.nextLine();
                return new SkirtBuilder().setSize(size).setMaterial(material).setColor(color).setWaistline(waistline).setPattern(pattern).build();
            default:
                return null;
        }
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
