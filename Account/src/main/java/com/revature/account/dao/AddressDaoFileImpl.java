/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

import com.revature.account.dto.Address;
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
public class AddressDaoFileImpl implements AddressDao {
    
    private static final String ADDRESS_FILE = "address.txt";
    private static final String DELIMITER = "::";
    private Map<Integer, Address> addressMap = new HashMap<>();

    @Override
    public void addAddress(Address address) throws AccountPersistenceException {
        int addressId = getAllAddresses().size();
        address.setAddressId(addressId);
        addressMap.put(address.getAddressId(), address);
        writeAddresses();
    }

    @Override
    public void deleteAddress(int addressId) throws AccountPersistenceException {
        addressMap.remove(addressId);
        writeAddresses();
    }

    @Override
    public void updateAddress(Address address) throws AccountPersistenceException {
        addressMap.replace(address.getAddressId(), address);
        writeAddresses();
    }

    @Override
    public Address getAddressByAddressId(int addressId) throws AccountPersistenceException {
        loadAddresses();
        return addressMap.get(addressId);
    }

    @Override
    public List<Address> getAllAddresses() throws AccountPersistenceException {
        loadAddresses();
        return new ArrayList(addressMap.values());
    }
    
    private void loadAddresses() throws AccountPersistenceException {
        Scanner sc;
        
        try {
            sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AccountPersistenceException("Could not load file.", e);
        }
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Address address = new Address();
            address.setAddressId(new Integer(currentTokens[0]));
            address.setStreet(currentTokens[1]);
            address.setCity(currentTokens[2]);
            address.setState(currentTokens[3]);
            address.setZip(currentTokens[4]);
            addressMap.put(address.getAddressId(), address);
        }
        sc.close();
    }
    
    private void writeAddresses() throws AccountPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AccountPersistenceException("Could not save file.", e);
        }
        for (Address address : addressMap.values()) {
            out.println(address.getAddressId() + DELIMITER + 
                    address.getStreet() + DELIMITER + 
                    address.getCity() + DELIMITER + 
                    address.getState() + DELIMITER + 
                    address.getZip());
            out.flush();
        }
        out.close();
    }
}
