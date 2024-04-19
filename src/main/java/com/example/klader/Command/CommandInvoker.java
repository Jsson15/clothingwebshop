package com.example.klader.Command;

// Command invoker
public class CommandInvoker {
    private Command orderCommand;
    private Command clearCommand;

    public CommandInvoker(Command orderCommand, Command clearCommand) {
        this.orderCommand = orderCommand;
        this.clearCommand = clearCommand;
    }

    public void order() {
        orderCommand.execute();
    }

    public void clear() {
        clearCommand.execute();
    }
}

