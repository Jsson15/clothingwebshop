package com.example.klader.App;

import com.example.klader.Builder.ClothingBuilder;
import com.example.klader.Clothing.ClothingItem;
import com.example.klader.Command.CommandPipeline;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<ClothingBuilder> builders = new ArrayList<>(); //builder lista
    private List<CommandPipeline> pipelines = new ArrayList<>(); //pipeline lista
    private List<ClothingItem> clothes = new ArrayList<>(); // klädeslista
    private static OrderService orderService = null;

    private OrderService() {
    }

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }


    public void addProduct(ClothingBuilder clothingBuilder) {
        builders.add(clothingBuilder);
    }

    public void addPipeLine(CommandPipeline pipeline) {
        pipelines.add(pipeline);
    }

    public void execute() {
        for (ClothingBuilder builder : builders) {
            builder.build();
        }

        for (CommandPipeline pipeline : pipelines) {
            clothes.add(pipeline.execute());
        }
    }

    public String getOrder() {
        int numberOfSkirts = 0;
        int numberOfPants = 0;
        int numberOfShirts = 0;

        for (ClothingBuilder builder : builders) {
            if (builder.getClothing().getClass().getSimpleName().equals("Pants")) {
                numberOfPants += 1;
            } else if (builder.getClothing().getClass().getSimpleName().equals("TShirt")) {
                numberOfShirts += 1;
            } else if (builder.getClothing().getClass().getSimpleName().equals("Skirt")) {
                numberOfSkirts += 1;
            }
        }

        String skirtsss = "";
        String tShirtsss = "";
        if (numberOfShirts != 1) {
            tShirtsss = "s";
        }
        if (numberOfSkirts != 1) {
            skirtsss = "s";
        }
        String order = numberOfPants + " pants, " + numberOfShirts + " TShirt" + tShirtsss + " and " + numberOfSkirts + " skirt" + skirtsss;
        return order;
    }

    public double getSum() {
        double sum = 0;
        for (ClothingBuilder builder : builders) {
            sum += builder.getClothing().getPrice();
        }
        return sum;
    }


    public void emptyOrderService() {
        builders.clear();
        pipelines.clear();
        clothes.clear();
    }

    public List<ClothingBuilder> getBuilders() {
        return builders;
    }

    public void setBuilders(List<ClothingBuilder> builders) {
        this.builders = builders;
    }

    public List<ClothingItem> getClothes() {
        return clothes;
    }

    public void setClothes(List<ClothingItem> clothes) {
        this.clothes = clothes;
    }

    public List<CommandPipeline> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<CommandPipeline> pipelines) {
        this.pipelines = pipelines;
    }

}

