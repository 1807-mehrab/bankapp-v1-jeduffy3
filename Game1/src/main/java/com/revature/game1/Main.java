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
public class Main {
    
    private Parser parser;
    private Dice dice;
    
    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }
    
    public void play() {
        System.out.println("Welcome to the dice game.");
        
        boolean finished = false;
        while (!finished) {
            finished = processCommand(parser.getCommand());
        }
        System.out.println("Thanks for playing.");
    }
    
    private boolean processCommand(Command command) {
        boolean quit = false;
        
        if (command.isUnknown()) {
            System.out.println("I don't understand.");
            return false;
        }
        
        switch (command.getCommandWord()) {
            case "go":
                System.out.println("You rolled a " + dice.roll());
                break;
            case "quit":
                System.out.println("Quitting the game");
                quit = true;
                break;
            default:
                System.out.println("Error");
                break;
        }
        return quit;
    }
}
