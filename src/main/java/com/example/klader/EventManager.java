package com.example.klader;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            try {
                observer.update(message);
            } catch (Exception e) {
                System.err.println("Error notifying observer: " + e.getMessage());
            }
        }
    }
}
