/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.controller;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dto.Account;
import com.revature.account.dto.Address;
import com.revature.account.dto.User;
import com.revature.account.service.AccountServiceLayer;
import com.revature.account.service.AddressServiceLayer;
import com.revature.account.service.UserServiceLayer;
import com.revature.account.view.AccountView;

/**
 *
 * @author James
 */
public class AccountController {
    
    private AccountServiceLayer accountServiceLayer;
    private UserServiceLayer userServiceLayer;
    private AddressServiceLayer addressServiceLayer;
    private AccountView accountView;
    
    public AccountController(AccountServiceLayer accountServiceLayer, 
           // UserServiceLayer userServiceLayer, 
            //AddressServiceLayer addressServiceLayer, 
            AccountView accountView) {
        this.accountServiceLayer = accountServiceLayer;
        //this.userServiceLayer = userServiceLayer;
        //this.addressServiceLayer = addressServiceLayer;
        this.accountView = accountView;
    }
    
    public void run() {
        boolean keepGoing = true;
        int mainMenuSelection = 0;
        try {
            while (keepGoing) {
                mainMenuSelection = getMainMenuSelection();
                switch (mainMenuSelection) {
                    case 1:
                        addAccount();
                        break;
                    case 2:
                        deleteAccount();
                        break;
//                    case 3:
//                        System.out.println("Implementation in progress");
//                        break;
                    case 3:
                        viewAccount();
                        break;
                    case 4:
                        listAccounts();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;
                }
            }
        } catch (AccountPersistenceException e) {
            accountView.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMainMenuSelection() {
        return accountView.printMainMenuAndGetSelection();
    }
    
    private void addAccount() throws AccountPersistenceException {
        accountView.displayAddAccountBanner();
//        Address address = accountView.getNewAddressInfo();
//        addressServiceLayer.addAddress(address);
//        User user = accountView.getNewUserInfo();
//        user.setAddressId(address.getAddressId());
//        userServiceLayer.addUser(user);
        Account account = accountView.getNewAccountInfo();
        //account.setUserId(user.getUserId());
        accountServiceLayer.addAccount(account);
    }
    
    private void deleteAccount() throws AccountPersistenceException {
        accountView.displayDeleteAccountBanner();
        int accountId = accountView.getAccountIdSelection();
        accountServiceLayer.deleteAccount(accountId);
    }
    
    private void updateAccount() {
        
    }
    
    public void viewAccount() throws AccountPersistenceException {
        accountView.displayViewAccountBanner();
        int accountId = accountView.getAccountIdSelection();
        Account account = accountServiceLayer.getAccountByAccountId(accountId);
//        User user = userServiceLayer.getUserByUserId(account.getUserId());
//        Address address = addressServiceLayer.getAddressByAddressId(user.getAddressId());
        accountView.displayAccount(account);
    }
    
    public void listAccounts() throws AccountPersistenceException {
        accountView.displayAllAccountsBanner();
        for (Account account : accountServiceLayer.getAllAccounts()) {
//            User user = userServiceLayer.getUserByUserId(account.getUserId());
//            Address address = addressServiceLayer.getAddressByAddressId(user.getAddressId());
            accountView.displayAccount(account);
        }
    }
    
    private void unknownCommand() {
        accountView.displayUnknownCommandBanner();
    }
    
    
}
