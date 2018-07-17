/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String inputString = sc.nextLine();
        double input = Double.parseDouble(inputString);
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean validate = true;
        double input;
        do {            
            System.out.println(prompt);
            String inputString = sc.nextLine();
            input = Double.parseDouble(inputString);
            if (input >= min && input <= max) {
                validate = false;
            }
        } while (validate);
        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String inputString = sc.nextLine();
        float input = Float.parseFloat(inputString);
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean validate = true;
        float input;
        do {            
            System.out.println(prompt);
            String inputString = sc.nextLine();
            input = Float.parseFloat(inputString);
            if (input >= min && input <= max) {
                validate = false;
            }
        } while (validate);
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String inputString = sc.nextLine();
        int input = Integer.parseInt(inputString);
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean validate = true;
        int input;
        do {            
            System.out.println(prompt);
            String inputString = sc.nextLine();
            input = Integer.parseInt(inputString);
            if (input >= min && input <= max) {
                validate = false;
            }
        } while (validate);
        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String inputString = sc.nextLine();
        long input = Long.parseLong(inputString);
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean validate = true;
        long input;
        do {            
            System.out.println(prompt);
            String inputString = sc.nextLine();
            input = Long.parseLong(inputString);
            if (input >= min && input <= max) {
                validate = false;
            }
        } while (validate);
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        String inputString = sc.nextLine().trim();
        BigDecimal input = new BigDecimal(inputString).setScale(2, RoundingMode.HALF_UP);
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min) {
        boolean validate = true;
        BigDecimal input;
        do {            
            System.out.println(prompt);
            String inputString = sc.nextLine().trim();
            input = new BigDecimal(inputString).setScale(2, RoundingMode.HALF_UP);
            if (input.compareTo(min) > 0) {
                validate = false;
            }
        } while (validate);
        return input;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = sc.nextLine();
        return input;
    }
    
}
