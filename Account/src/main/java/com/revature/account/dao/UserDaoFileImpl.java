/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

import com.revature.account.dto.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class UserDaoFileImpl implements UserDao {

    private static final String USER_FILE = "user.txt";
    private static final String DELIMITER = "::";
    private Map<Integer, User> userMap = new HashMap<>();
    
    @Override
    public void addUser(User user) throws AccountPersistenceException {
        int userId = getAllUsers().size();
        user.setUserId(userId);
        userMap.put(user.getUserId(), user);
        writeUsers();
    }

    @Override
    public void deleteUser(int userId) throws AccountPersistenceException {
        userMap.remove(userId);
        writeUsers();
    }

    @Override
    public void updateUser(User user) throws AccountPersistenceException {
        userMap.replace(user.getUserId(), user);
        writeUsers();
    }

    @Override
    public User getUserByUserId(int userId) throws AccountPersistenceException {
        loadUsers();
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() throws AccountPersistenceException {
        loadUsers();
        return new ArrayList(userMap.values());
    }
    
    private void loadUsers() throws AccountPersistenceException {
        Scanner sc;
        
        try {
            sc = new Scanner(new BufferedReader(new FileReader(USER_FILE)));
        } catch (FileNotFoundException e) {
            throw new AccountPersistenceException("Could not load file.", e);
        }
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            User user = new User();
            user.setUserId(new Integer(currentTokens[0]));
            user.setFirstName(currentTokens[1]);
            user.setLastName(currentTokens[2]);
            user.setAddressId(new Integer(currentTokens[3]));
            userMap.put(user.getUserId(), user);
        }
        sc.close();
    }
    
    private void writeUsers() throws AccountPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(USER_FILE));
        } catch (IOException e) {
            throw new AccountPersistenceException("Could not save file.", e);
        }
        for (User user : userMap.values()) {
            out.println(user.getUserId() + DELIMITER + 
                    user.getFirstName() + DELIMITER + 
                    user.getLastName() + DELIMITER +
                    user.getAddressId());
            out.flush();
        }
        out.close();
    }
}
