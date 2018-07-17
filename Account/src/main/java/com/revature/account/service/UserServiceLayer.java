/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dto.User;
import java.util.List;

/**
 *
 * @author James
 */
public interface UserServiceLayer {
    
    public void addUser(User user)throws AccountPersistenceException;
    
    public void deleteUser(int userId) throws AccountPersistenceException;
    
    public void updateUser(User user) throws AccountPersistenceException;
    
    public User getUserByUserId(int userId) throws AccountPersistenceException;
    
    public List<User> getAllUsers() throws AccountPersistenceException;
}
