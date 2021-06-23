package com.pokemachine.api.crud;

import java.sql.*;

import com.pokemachine.api.database.DBService;

/**
 * Account Crud
 * @author gbrextreme
 */
public class AccountCrud {
    
    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static AccountCrud instance;
    
    /**
     * Constructor
     */
    private AccountCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static AccountCrud getInstance() {
        if (AccountCrud.instance == null) {
            AccountCrud.instance = new AccountCrud();
        }
        return AccountCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        AccountCrud.instance = null;
    }
}
