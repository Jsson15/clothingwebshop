package com.example.klader.App;


import com.example.klader.Builder.ClothingBuilder;
import com.example.klader.Builder.PantsBuilder;
import com.example.klader.Builder.SkirtBuilder;
import com.example.klader.Builder.TShirtBuilder;
import com.example.klader.Business.CEO;
import com.example.klader.Business.Customer;
import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Command.*;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Customer customer;
    private boolean shopping = true;

    public void welcomeMenu() {
        System.out.println("Welcome to ClothesOrderApp");
        System.out.println("Enter yor name or type \"exit\" to close the app");
        String choice = scanner.nextLine();
        if (!choice.equalsIgnoreCase("exit")) {
            customer = new Customer();
            customer.setName(choice);
            menu();
        } else System.out.println("Closing App");
    }

    public void menu() {

        while (shopping) {

            System.out.println("\nEnter your number of choice");
            System.out.println("1. Design a pair of pants: 749:- SEK");
            System.out.println("2. Design a TShirt: 599:- SEK");
            System.out.println("3. Design a skirt: 249:- SEK");
            System.out.println("4. Place an order");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1": //Pants
                    case1();
                    break;
                case "2": //TShirt
                    case2();
                    break;

                case "3": //Skirt
                    case3();
                    break;

                case "4": //Place order
                    placeOrder();
                    break;

                case "5":
                    System.out.println("Exiting");
                    shopping = false;
                    break;

                default:
                    System.out.println("Enter a number between 1-5");
            }
        }
    }

    public void case1() {
        System.out.println("Designing pants");

        PantsBuilder pantsBuilder = (PantsBuilder) builderDesign(new PantsBuilder());
        CommandPipeline commandPipeline = new CommandPipeline();
        commandPipeline.setClothing(pantsBuilder.getClothing());
        commandDesign(pantsBuilder, commandPipeline);
        addToCart(pantsBuilder, commandPipeline);
    }

    public void case2() {
        System.out.println("Designing TShirt");

        TShirtBuilder shirtBuilder = (TShirtBuilder) builderDesignTshirt(new TShirtBuilder());
        CommandPipeline commandPipeline = new CommandPipeline();
        commandPipeline.setClothing(shirtBuilder.getClothing());
        commandDesign(shirtBuilder, commandPipeline);
        addToCart(shirtBuilder, commandPipeline);
    }

    private void case3() {
        System.out.println("Designing skirt");

        SkirtBuilder skirtBuilder = (SkirtBuilder) builderDesign(new SkirtBuilder());
        CommandPipeline commandPipeline = new CommandPipeline();
        commandPipeline.setClothing(skirtBuilder.getClothing());
        commandDesign(skirtBuilder, commandPipeline);
        addToCart(skirtBuilder, commandPipeline);
    }


    private ClothingBuilder builderDesign(ClothingBuilder clothingBuilder) {

        System.out.println("\nChoose material, Jeans or Leather");
        String material = scanner.nextLine();
        while (!material.equalsIgnoreCase("Jeans") && !material.equalsIgnoreCase("Leather")) {
            System.out.println("Material not available, choose Jeans or Leather");
            material = scanner.nextLine();
        }
        clothingBuilder.addMaterial(material);


        System.out.println("\nChoose size M or L ");
        String size = scanner.nextLine();
        while (!size.equalsIgnoreCase("M") && !size.equalsIgnoreCase("L")) {
            System.out.println("Size not available, choose M or L");
            size = scanner.nextLine();
        }
        clothingBuilder.addSize(size);

        System.out.println("\nChoose color, Black or Blue");
        String color = scanner.nextLine();
        while (!color.equalsIgnoreCase("Black") && !color.equalsIgnoreCase("Blue")) {
            System.out.println("Color not available, choose Black or Blue");
            color = scanner.nextLine();
        }
        clothingBuilder.addColor(color);
        return clothingBuilder;
    }


    private ClothingBuilder builderDesignTshirt(ClothingBuilder clothingBuilder) {

        System.out.println("\nChoose material, Siden or Cotton");
        String material = scanner.nextLine();
        while (!material.equalsIgnoreCase("Siden") && !material.equalsIgnoreCase("Cotton")) {
            System.out.println("Material not available, choose Siden or Cotton");
            material = scanner.nextLine();
        }
        clothingBuilder.addMaterial(material);


        System.out.println("\nChoose size M or L ");
        String size = scanner.nextLine();
        while (!size.equalsIgnoreCase("M") && !size.equalsIgnoreCase("L")) {
            System.out.println("Size not available, choose M or L");
            size = scanner.nextLine();
        }
        clothingBuilder.addSize(size);

        System.out.println("\nChoose color, Grey or White");
        String color = scanner.nextLine();
        while (!color.equalsIgnoreCase("Grey") && !color.equalsIgnoreCase("White")) {
            System.out.println("Color not available, choose Grey or White");
            color = scanner.nextLine();
        }
        clothingBuilder.addColor(color);
        return clothingBuilder;
    }

    public void commandDesign(ClothingBuilder clothingBuilder, CommandPipeline decoratorPipeline) {

        String cutShort = "";
        String cutMedium = "";
        String cutLong = "";
        String typeOfClothing = clothingBuilder.getClothing().getClass().getSimpleName();
        String cut = "";

        if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Pants")) {
            cut = "length";
            cutShort = "Short";
            cutMedium = "Mid";
            cutLong = "Long";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("TShirt")) {
            cut = "sleeve";
            cutShort = "Short";
            cutMedium = "Mid";
            cutLong = "Long";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Skirt")) {
            cut = "length";
            cutShort = "Short";
            cutMedium = "Mid";
            cutLong = "Long";
        }

        System.out.println("\nChoose " + cut + " for " + typeOfClothing + " 1. " + cutShort + ", 2. " + cutMedium + " or 3. " + cutLong);
        String answerCut = scanner.nextLine();

        while (!answerCut.equalsIgnoreCase("1") && !answerCut.equalsIgnoreCase("2") && !answerCut.equalsIgnoreCase("3")) {
            System.out.println("\nChoose " + cut + " 1. " + cutShort + ", 2. " + cutMedium + " or 3. " + cutLong);
            answerCut = scanner.nextLine();
        }
        if (answerCut.equalsIgnoreCase("1")) {
            decoratorPipeline.addCommand(new CutSCommand());
        } else if (answerCut.equalsIgnoreCase("2")) {
            decoratorPipeline.addCommand(new CutMCommand());
        } else {
            decoratorPipeline.addCommand(new CutLCommand());
        }

        String sew = "";
        String sew1 = "";
        String sew2 = "";
        String sew3 = "";
        if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Pants")) {
            sew = "fit";
            sew1 = "Slim fit";
            sew2 = "Regular";
            sew3 = "Loose";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("TShirt")) {
            sew = "neck";
            sew1 = "V-neck";
            sew2 = "U-neck";
            sew3 = "Polo";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Skirt")) {
            sew = "waist";
            sew1 = "High";
            sew2 = "Low";
            sew3 = "Mid";
        }

        System.out.println("\nChoose type of " + sew + " for " + typeOfClothing + " 1. " + sew1 + ", 2. " + sew2 + " or 3. " + sew3);
        String answerSew = scanner.nextLine();

        while (!answerSew.equals("1") && !answerSew.equals("2") && !answerSew.equals("3")) {
            System.out.println("\nType only the number of the choice you want 1. " + sew1 + ", 2. " + sew2 + " or 3. " + sew3);
            answerSew = scanner.nextLine();
        }
        if (answerSew.equals("1")) {
            decoratorPipeline.addCommand(new Sew1Command());
        } else if (answerSew.equals("2")) {
            decoratorPipeline.addCommand(new Sew2Command());
        } else {
            decoratorPipeline.addCommand(new Sew3Command());
        }

    }

    private void addToCart(ClothingBuilder clothingBuilder, CommandPipeline commandPipeline) {
        System.out.println("Add " + clothingBuilder.getClothing().getClass().getSimpleName() + " " + clothingBuilder.getClothing().getPrice() + ":- SEK to your shopping cart?  (y/n)");

        String answer = scanner.nextLine();

        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.println("enter y or n");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("y")) {
            OrderService.getInstance().addProduct(clothingBuilder);       //Lägger till clothesBuilder till orderservice
            OrderService.getInstance().addPipeLine(commandPipeline);  //lägger till pipeline med commands till orderServicen
            System.out.println(clothingBuilder.getClothing().getClass().getSimpleName() + " added to your cart");
            System.out.println("Continue shopping or press 4 to place your order");
        } else {
            System.out.println(clothingBuilder.getClothing().getClass().getSimpleName() + " not added to your cart, returning to start menu");
        }
    }

    private void placeOrder() {

        if (OrderService.getInstance().getSum() == 0) {
            System.out.println("You have no items in your shopping-cart. Please add an item to place an order");
        } else {
            System.out.println("Your order: ");
            System.out.println(OrderService.getInstance().getOrder() + ". Total: " + OrderService.getInstance().getSum() + ":- SEK");

            System.out.println("Do you want to buy these items? (y/n)");
            String answer = scanner.nextLine();

            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Answer y or n");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("y")) {
                Listener listener = new Listener();
                listener.addPropertyChangeListener(CEO.getInstance());
                System.out.println("placing order for purchase \n");
                listener.setBuilding(OrderService.getInstance().getOrder());
                OrderService.getInstance().execute();

                System.out.println("\nReceipt for " + customer.getName());
                for (ClothingItem clothing : OrderService.getInstance().getClothes()) {
                    clothing.getDetails();

                }
                System.out.println("Total " + OrderService.getInstance().getSum() + ":- SEK");
                OrderService.getInstance().emptyOrderService();
            }

            System.out.println("\nDo you wish to exit the shop");
            String continueAnswer = scanner.nextLine();
            if (continueAnswer.equalsIgnoreCase("y")) {
                shopping = false;
            } else System.out.println("Ready to place new order");

        }
    }
}
