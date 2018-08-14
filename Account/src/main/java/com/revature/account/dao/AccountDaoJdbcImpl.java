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

    private static final String SQL_INSERT_ACCOUNT 
            = "INSERT INTO account (account_balance, first_name, last_name) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_ACCOUNT 
            = "DELETE FROM account WHERE account_id = ?";
    
    private static final String SQL_SELECT_ACCOUNT_BY_ACCOUNT_ID 
            = "SELECT * FROM account WHERE account_id = ?";
    
    private static final String SQL_SELECT_ALL_ACCOUNTS 
            = "SELECT * FROM account";
    
    @Override
    public void addAccount(Account account) throws AccountPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_ACCOUNT);
            ps.setString(1, account.getAccountBalance().toString());
            ps.setString(2, account.getFirstName());
            ps.setString(3, account.getLastName());
            rs = ps.executeQuery();
        } catch (SQLException | IOException e) {
            throw new AccountPersistenceException("Could not save file.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new AccountPersistenceException("Could not save file.", e);
            }
        }
    }

    @Override
    public void deleteAccount(int accountId) throws AccountPersistenceException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_DELETE_ACCOUNT);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
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
            ps = conn.prepareStatement(SQL_SELECT_ACCOUNT_BY_ACCOUNT_ID);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getInt("account_id"));
                account.setAccountBalance(new BigDecimal(rs.getString("account_balance")));
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
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
        ResultSet rs = null;
        List<Account> accounts = new ArrayList<>();
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccountId(rs.getInt("account_id"));
                account.setAccountBalance(new BigDecimal(rs.getString("account_balance")));
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
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
