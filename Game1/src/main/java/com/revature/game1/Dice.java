/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.game1;

import java.util.Random;

/**
 *
 * @author James
 */
public class Dice {
    private int die1;
    private int die2;
    
    Random ranGen = new Random();
    
    public int roll() {
        
        die1 = ranGen.nextInt(6) + 1;
        die2 = ranGen.nextInt(6) + 1;
        return die1 + die2;
    }
}
