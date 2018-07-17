/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account.dao;

/**
 *
 * @author James
 */
public class AccountPersistenceException extends Exception {

    public AccountPersistenceException(String string) {
        super(string);
    }

    public AccountPersistenceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
