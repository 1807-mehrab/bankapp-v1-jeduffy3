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
public interface Account {
    
    public void deposit(double depositAmount);
    
    public void withdraw(double withdrawAmount);
    
    public void transfer(Account toAccount, double transferAmount);
    
    public double getBalance();
}
