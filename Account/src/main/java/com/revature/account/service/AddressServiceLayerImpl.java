/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.service;

import com.revature.account.dao.AccountPersistenceException;
import com.revature.account.dao.AddressDao;
import com.revature.account.dto.Address;
import java.util.List;

/**
 *
 * @author James
 */
public class AddressServiceLayerImpl implements AddressServiceLayer {

    private AddressDao addressDao;
    
    public AddressServiceLayerImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    
    @Override
    public void addAddress(Address address) throws AccountPersistenceException {
        addressDao.addAddress(address);
    }

    @Override
    public void deleteAddress(int addressId) throws AccountPersistenceException {
        addressDao.deleteAddress(addressId);
    }

    @Override
    public void updateAddress(Address address) throws AccountPersistenceException {
        addressDao.updateAddress(address);
    }

    @Override
    public Address getAddressByAddressId(int addressId) throws AccountPersistenceException {
        return addressDao.getAddressByAddressId(addressId);
    }

    @Override
    public List<Address> getAllAddresses() throws AccountPersistenceException {
        return addressDao.getAllAddresses();
    }
    
}
