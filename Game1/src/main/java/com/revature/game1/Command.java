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
public class Command {
    
    private String commandWord;
    
    public Command(String commandWord) {
        this.commandWord = commandWord;
    }
    
    public String getCommandWord() {
        return commandWord;
    }
    
    public boolean isUnknown() {
        return (commandWord == null);
    }
}
