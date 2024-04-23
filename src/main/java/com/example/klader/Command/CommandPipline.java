package com.example.klader.Command;

import com.example.klader.ClothingItem;

import java.util.ArrayList;
import java.util.List;

public class CommandPipline {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands(ClothingItem item) {
        for (Command command : commands) {
            command.execute(item);
        }
    }
}
