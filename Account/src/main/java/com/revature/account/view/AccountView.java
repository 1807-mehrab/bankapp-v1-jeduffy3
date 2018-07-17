/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.view;

import com.revature.account.dto.Account;
import com.revature.account.dto.Address;
import com.revature.account.dto.User;
import java.math.BigDecimal;

/**
 *
 * @author James
 */
public class AccountView {
    
    private UserIO io;
    
    public AccountView(UserIO io) {
        this.io = io;
    }
    
    public int printMainMenuAndGetSelection() {
        io.print("=== Main Menu ===");
        io.print("\t1 = Add Account");
        io.print("\t2 = Delete Account");
        io.print("\t3 = Update Account");
        io.print("\t4 = View Account");
        io.print("\t5 = List Accounts");
        io.print("\t6 = Exit");
        return io.readInt("Select from the above choices.", 1, 6);
    }
    
    public Account getNewAccountInfo() {
        Account account = new Account();
        account.setAccountBalance(io.readBigDecimal("Enter your initial balance:", BigDecimal.ZERO));
        return account;
    }
    
    public User getNewUserInfo() {
        User user = new User();
        user.setFirstName(io.readString("Enter your first name:"));
        user.setLastName(io.readString("Enter your last name:"));
        return user;
    }
    
    public Address getNewAddressInfo() {
        Address address = new Address();
        address.setStreet(io.readString("Enter your street:"));
        address.setCity(io.readString("Enter your city:"));
        address.setState(io.readString("Enter your state:"));
        address.setZip(io.readString("Enter your zip:"));
        return address;
    }
    
    public int getAccountIdSelection() {
        return io.readInt("Enter the account id:");
    }
    
    public void displayAccount(Account account, User user, Address address) {
        io.print(user.getFirstName() + " " + user.getLastName());
        io.print(address.getStreet());
        io.print(address.getCity() + ", " + address.getState());
        io.print(address.getZip());
        io.print("Balance: " + account.getAccountBalance().toString());
    }
    
    public void displayAddAccountBanner() {
        io.print("=== Add Account ===");
    }
    
    public void displayDeleteAccountBanner() {
        io.print("=== Remove Account ===");
    }
    
    public void displayViewAccountBanner() {
        io.print("=== View Account ===");
    }
    
    public void displayAllAccountsBanner() {
        io.print("=== All Accounts ===");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("=== Unknown Command ===");
    }
    
    public void displayErrorMessage(String errorMessage) {
        io.print("=== Error ===");
        io.print(errorMessage);
    }
}
