package com.example.klader;

public class CEO implements Observer {
    private String id;
    private String name;

    public CEO() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public void update(String message) {
        if (message.contains("tillverkas")) {
            handleManufacturingNotification(message);
        } else if (message.contains("klar")) {
            handleCompletionNotification(message);
        } else {
            System.out.println("CEO notified: " + message);
        }
    }

    private void handleManufacturingNotification(String message) {
        System.out.println("CEO Alert - Manufacturing Start: " + message);
    }

    private void handleCompletionNotification(String message) {
        System.out.println("CEO Alert - Manufacturing Complete: " + message);
    }
}
