package com.example.klader.Command;

import com.example.klader.Clothing.ClothingItem;

// Command interface
public interface Command {
    ClothingItem decorate(ClothingItem clothing);
}

