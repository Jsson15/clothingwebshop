package com.example.klader.Command;

import com.example.klader.App.Listener;
import com.example.klader.Business.CEO;
import com.example.klader.Clothing.ClothingItem;

import java.util.ArrayList;
import java.util.List;

public class CommandPipeline {

        private List<Command> pipelineCommands = new ArrayList<>();
        private ClothingItem clothing = null;
        private Listener Listener = new Listener();

        public CommandPipeline() {
            Listener.addPropertyChangeListener(CEO.getInstance());
        }

        public void addCommand(Command command) {
            pipelineCommands.add(command);
        }

        public ClothingItem execute() {
            for (Command command : pipelineCommands) {
                clothing = command.decorate(clothing);
            }
            Listener.setDecorating(clothing.getClass().getSimpleName() + " id " + clothing.getId());
            return clothing;
        }

        public ClothingItem getClothing() {
            return clothing;
        }
        public void setClothing(ClothingItem clothing) {
            this.clothing = clothing;
        }
    }

