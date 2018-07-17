/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

import com.revature.account.dto.Account;
import com.revature.account.dto.User;
import com.revature.account.util.ConnectionUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class UserDaoJdbcImpl implements UserDao {

    @Override
    public void addUser(User user) throws AccountPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int userId) throws AccountPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User user) throws AccountPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUserId(int userId) throws AccountPersistenceException {
        PreparedStatement ps = null;
        User user = null;
        ResultSet rs = null;
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM USER WHERE USER_ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int uid = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int addressId = rs.getInt("address_id");
                user = new User();
                user.setUserId(uid);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAddressId(addressId);
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
        return user;
    }

    @Override
    public List<User> getAllUsers() throws AccountPersistenceException {
        PreparedStatement ps = null;
        User user = null;
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM USER";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int uid = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int addressId = rs.getInt("address_id");
                user = new User();
                user.setUserId(uid);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAddressId(addressId);
                users.add(user);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new AccountPersistenceException("Could not load file.", e);
        }
        return users;
    }
    
}
