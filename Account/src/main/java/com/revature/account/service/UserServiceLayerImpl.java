/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dao.UserDao;
import com.revature.account.dto.User;
import java.util.List;

/**
 *
 * @author James
 */
public class UserServiceLayerImpl implements UserServiceLayer {

    private UserDao userDao;
    
    public UserServiceLayerImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public void addUser(User user) throws AccountPersistenceException {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int userId) throws AccountPersistenceException {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) throws AccountPersistenceException {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByUserId(int userId) throws AccountPersistenceException {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public List<User> getAllUsers() throws AccountPersistenceException {
        return userDao.getAllUsers();
    }
    
}
