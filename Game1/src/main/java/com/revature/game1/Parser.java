/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.game1;

import java.util.Scanner;

/**
 *
 * @author James
 */
public class Parser {
    private CommandWords commands;
    private Scanner sc;
    
    public Parser() {
        commands = new CommandWords();
        sc = new Scanner(System.in);
    }
    
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        inputLine = sc.nextLine();
        
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
        }
        
        if (commands.isCommand(word1)) {
            return new Command(word1);
        } else {
            return new Command(null);
        }
    }
    
    public void showCommands() {
        commands.showAll();
    }
}
