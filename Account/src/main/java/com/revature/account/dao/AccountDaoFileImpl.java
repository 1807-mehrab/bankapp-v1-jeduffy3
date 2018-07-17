/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

import com.revature.account.dto.Account;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class AccountDaoFileImpl /*implements AccountDao */{
//
//    private static final String ACCOUNT_FILE = "account.txt";
//    private static final String DELIMITER = "::";
//    private Map<Integer, Account> accountMap = new HashMap<>();
//    
//    @Override
//    public void addAccount(Account account) throws AccountPersistenceException {
//        int accountId = getAllAccounts().size();
//        account.setAccountId(accountId);
//        accountMap.put(account.getAccountId(), account);
//        writeAccounts();
//    }
//
//    @Override
//    public void deleteAccount(int accountId) throws AccountPersistenceException {
//        accountMap.remove(accountId);
//        writeAccounts();
//    }
//
//    @Override
//    public void updateAccount(Account account) throws AccountPersistenceException {
//        accountMap.replace(account.getAccountId(), account);
//        writeAccounts();
//    }
//
//    @Override
//    public Account getAccountByAccountId(int accountId) throws AccountPersistenceException {
//        loadAccounts();
//        return accountMap.get(accountId);
//    }
//
//    @Override
//    public List<Account> getAllAccounts() throws AccountPersistenceException {
//        loadAccounts();
//        return new ArrayList(accountMap.values());
//    }
//    
//    private void loadAccounts() throws AccountPersistenceException {
//        Scanner sc;
//        
//        try {
//            sc = new Scanner(new BufferedReader(new FileReader(ACCOUNT_FILE)));
//        } catch (FileNotFoundException e) {
//            throw new AccountPersistenceException("Could not load file.", e);
//        }
//        
//        String currentLine;
//        String[] currentTokens;
//        
//        while (sc.hasNextLine()) {
//            currentLine = sc.nextLine();
//            currentTokens = currentLine.split(DELIMITER);
//            Account account = new Account();
//            account.setAccountId(new Integer(currentTokens[0]));
//            account.setAccountBalance(new BigDecimal(currentTokens[1]));
//            account.setUserId(new Integer(currentTokens[2]));
//            accountMap.put(account.getAccountId(), account);
//        }
//        sc.close();
//    }
//    
//    private void writeAccounts() throws AccountPersistenceException {
//        PrintWriter out;
//        
//        try {
//            out = new PrintWriter(new FileWriter(ACCOUNT_FILE));
//        } catch (IOException e) {
//            throw new AccountPersistenceException("Could not save file.", e);
//        }
//        for (Account account : accountMap.values()) {
//            out.println(account.getAccountId() + DELIMITER + 
//                    account.getAccountBalance() + DELIMITER + 
//                    account.getUserId());
//            out.flush();
//        }
//        out.close();
//    }
}
