/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.game1;

/**
 *
 * @author James
 */
public class CommandWords {
    private static final String[] validCommands = {
        "go", "quit"
    };
    
    public CommandWords() {}
    
    public boolean isCommand(String input) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(input)) {
                return true;
            }
        }
        return false;
    }
    
    public void showAll() {
        for (String validCommand : validCommands) {
            System.out.print(validCommand + " ");
        }
        System.out.println("");
    }
}
