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
        System.out.println("Enter yor name or type \"exit\" to close the shop");
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
            System.out.println("1. Design pants 749 KR");
            System.out.println("2. Design t-shirt 599 KR");
            System.out.println("3. Design skirt 249 KR");
            System.out.println("4. Place order");
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

        TShirtBuilder shirtBuilder = (TShirtBuilder) builderDesign(new TShirtBuilder());
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
        while (!size.equalsIgnoreCase("s") && !size.equalsIgnoreCase("l")) {
            System.out.println("Size not available, choose s or l");
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

    public void commandDesign(ClothingBuilder clothingBuilder, CommandPipeline decoratorPipeline) {

        String cutShort = "";
        String cutMedium = "";
        String cutLong = "";
        String typeOfClothing = clothingBuilder.getClothing().getClass().getSimpleName();
        String cut = "";

        if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Pants")) {
            cut = "length";
            cutShort = "Short";
            cutMedium = "Capri";
            cutLong = "Long";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("TShirt")) {
            cut = "sleeve";
            cutShort = "Short";
            cutMedium = "Bracelet sleeve";
            cutLong = "Long";
        } else if (clothingBuilder.getClothing().getClass().getSimpleName().equalsIgnoreCase("Skirt")) {
            cut = "length";
            cutShort = "Short";
            cutMedium = "Midi";
            cutLong = "Long";
        }

        System.out.println("\nChoose " + cut + " for " + typeOfClothing + " 1. " + cutShort + ", 2. " + cutMedium + " or 3. " + cutLong);
        String answerCut = scanner.nextLine();

        while (!answerCut.equalsIgnoreCase("1") && !answerCut.equalsIgnoreCase("2") && !answerCut.equalsIgnoreCase("3")) {
            System.out.println("\nChoose " + cut + " 1. " + cutShort + ", 2. " + cutMedium + " or 3. " + cutLong);
            answerCut = scanner.nextLine();
        }
        if (answerCut.equalsIgnoreCase("1")) {
            decoratorPipeline.addCommand(new CutShortCommand());
        } else if (answerCut.equalsIgnoreCase("2")) {
            decoratorPipeline.addCommand(new CutMediumCommand());
        } else {
            decoratorPipeline.addCommand(new CutLongCommand());
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
            decoratorPipeline.addCommand(new SewOption1Command());
        } else if (answerSew.equals("2")) {
            decoratorPipeline.addCommand(new SewOption2Command());
        } else {
            decoratorPipeline.addCommand(new SewOption3Command());
        }

    }

    private void addToCart(ClothingBuilder clothingBuilder, CommandPipeline commandPipeline) {
        System.out.println("Add " + clothingBuilder.getClothing().getClass().getSimpleName() + " " + clothingBuilder.getClothing().getPrice() + "§ to your shopping cart?");

        String answer = scanner.nextLine();

        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
            System.out.println("enter yes or no");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("yes")) {
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
            System.out.println(OrderService.getInstance().getOrder() + ". Total: " + OrderService.getInstance().getSum() + "§");

            System.out.println("Do you want to buy these items?");
            String answer = scanner.nextLine();

            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                System.out.println("Answer yes or no");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("yes")) {
                Listener listener = new Listener();
                listener.addPropertyChangeListener(CEO.getInstance());
                System.out.println("placing order for purchase \n");
                listener.setBuilding(OrderService.getInstance().getOrder()); //skickar iväg vad som beställts till CEO
                OrderService.getInstance().execute();

                System.out.println("\nReceipt for " + customer.getName());
                for (ClothingItem clothing : OrderService.getInstance().getClothes()) {
                    clothing.getDetails();

                }
                System.out.println("Total sum " + OrderService.getInstance().getSum() + "§");
                OrderService.getInstance().emptyOrderService(); //tömmer lista med pipelines, builders och clothes
            }

            System.out.println("\nDo you wish to exit the shop");
            String continueAnswer = scanner.nextLine();
            if (continueAnswer.equalsIgnoreCase("yes")) {
                shopping = false;
            } else System.out.println("Ready to place new order");

        }
    }
}
