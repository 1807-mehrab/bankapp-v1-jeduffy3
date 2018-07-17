/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dto.Account;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author James
 */
public interface AccountServiceLayer {
    
    public void addAccount(Account account) throws AccountPersistenceException;
    
    public void deleteAccount(int accountId) throws AccountPersistenceException;
    
    public void updateAccount(Account account) throws AccountPersistenceException;
    
    public Account getAccountByAccountId(int accountId) throws AccountPersistenceException;
    
    public List<Account> getAllAccounts() throws AccountPersistenceException;
    
    public void deposit(Account account, BigDecimal depositAmount);
    
    public void withdraw(Account account, BigDecimal withdrawAmount);
    
    public void transfer(Account fromAccount, Account toAccount, BigDecimal transferAmount);
}
