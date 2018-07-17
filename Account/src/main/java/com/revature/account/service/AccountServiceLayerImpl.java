/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountDao;
import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dto.Account;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author James
 */
public class AccountServiceLayerImpl implements AccountServiceLayer {

    private AccountDao accountDao;

    public AccountServiceLayerImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount(Account account) throws AccountPersistenceException {
        accountDao.addAccount(account);
    }

    @Override
    public void deleteAccount(int accountId) throws AccountPersistenceException {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Account account) throws AccountPersistenceException {
        accountDao.updateAccount(account);
    }

    @Override
    public Account getAccountByAccountId(int accountId) throws AccountPersistenceException {
        return accountDao.getAccountByAccountId(accountId);
    }

    @Override
    public List<Account> getAllAccounts() throws AccountPersistenceException {
        return accountDao.getAllAccounts();
    }

    @Override
    public void deposit(Account account, BigDecimal depositAmount) {
        if (depositAmount.compareTo(BigDecimal.ZERO) > 0) {
            account.getAccountBalance().add(depositAmount);
        }
    }

    @Override
    public void withdraw(Account account, BigDecimal withdrawAmount) {
        if (withdrawAmount.compareTo(BigDecimal.ZERO) > 0) {
            account.getAccountBalance().subtract(withdrawAmount);
        }
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, BigDecimal transferAmount) {
        withdraw(fromAccount, transferAmount);
        deposit(toAccount, transferAmount);
    }

}
