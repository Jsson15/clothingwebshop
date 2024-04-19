package com.example.klader;

// OrderSubject.java
public interface OrderSubject {
    void registerObserver(CEOObserver observer);
    void removeObserver(CEOObserver observer);
    void notifyCEOObserver(String message);
}
