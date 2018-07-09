/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account;

/**
 *
 * @author James
 */
public class SavingsAccount implements Account {

    private double balance;
    
    public SavingsAccount(double balance) {
        this.balance = balance;
    }
    
    @Override
    public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            balance += depositAmount;
        } else {
            System.out.println("Please enter a value greater than 0.00");
        }
    }

    @Override
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > 0) {
            balance -= withdrawAmount;
        } else {
            System.out.println("Please enter a value greater than 0.00");
        }
    }

    @Override
    public void transfer(Account toAccount, double transferAmount) {
        toAccount.deposit(transferAmount);
        balance -= transferAmount;
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
}
