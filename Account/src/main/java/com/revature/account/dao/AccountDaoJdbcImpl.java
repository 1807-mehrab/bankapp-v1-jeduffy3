/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

import com.revature.account.dto.Account;
import com.revature.account.util.ConnectionUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.net.aso.e;

/**
 *
 * @author James
 */
public class AccountDaoJdbcImpl implements AccountDao {

    @Override
    public void addAccount(Account account) throws AccountPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String balance = account.getAccountBalance().toString();
        String firstName = account.getFirstName();
        String lastName = account.getLastName();
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO ACCOUNT (account_balance, first_name, last_name) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, balance);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new AccountPersistenceException("Could not save file.", e);
        } catch (IOException e) {
            throw new AccountPersistenceException("Could not save file.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteAccount(int accountId) throws AccountPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAccount(Account account) throws AccountPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccountByAccountId(int accountId) throws AccountPersistenceException {
        PreparedStatement ps = null;
        Account account = null;
        ResultSet rs = null;
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int aid = rs.getInt("account_id");
                String accountBalanceString = rs.getString("account_balance");
                BigDecimal accountBalance = new BigDecimal(accountBalanceString);
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                account = new Account();
                account.setAccountId(aid);
                account.setAccountBalance(accountBalance);
                account.setFirstName(firstName);
                account.setLastName(lastName);
            }
        } catch (Exception e) {
            throw new AccountPersistenceException("Could not load file.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new AccountPersistenceException("Could not load file.", e);
            }
        }
        return account;
    }

    @Override
    public List<Account> getAllAccounts() throws AccountPersistenceException {
        PreparedStatement ps = null;
        Account account = null;
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ACCOUNT";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int accountId = rs.getInt("account_id");
                String accountBalanceString = rs.getString("account_balance");
                BigDecimal accountBalance = new BigDecimal(accountBalanceString);
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                account = new Account();
                account.setAccountId(accountId);
                account.setAccountBalance(accountBalance);
                account.setFirstName(firstName);
                account.setLastName(lastName);
                accounts.add(account);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new AccountPersistenceException("Could not load file.", e);
        }
        return accounts;
    }
    
}
