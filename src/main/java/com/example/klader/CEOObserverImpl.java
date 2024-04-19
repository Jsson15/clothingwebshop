package com.example.klader;

// CEOObserverImpl.java
public class CEOObserverImpl implements CEOObserver {
    @Override
    public void update(String message) {
        System.out.println("Meddelande till Wigells VD: " + message);
    }
}

