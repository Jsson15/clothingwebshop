package com.example.klader;

public class CEO implements Observer {
    private String id;
    private String name;

    public CEO() {}

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("CEO notified: " + message);
    }
}
