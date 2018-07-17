/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dto.Address;
import java.util.List;

/**
 *
 * @author James
 */
public interface AddressServiceLayer {
    
    public void addAddress(Address address) throws AccountPersistenceException;
    
    public void deleteAddress(int addressId) throws AccountPersistenceException;
    
    public void updateAddress(Address address) throws AccountPersistenceException;
    
    public Address getAddressByAddressId(int addressId) throws AccountPersistenceException;
    
    public List<Address> getAllAddresses() throws AccountPersistenceException;
}
