package com.pokemachine.api.crud;

import java.sql.*;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MCashMachine;

/**
 * Cash Machine Crud
 * @author gbrextreme
 */
public class CashMachineCrud implements DBCrud<MCashMachine> {
    
    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static CashMachineCrud instance;
    
    /**
     * Constructor
     */
    private CashMachineCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static CashMachineCrud getInstance() {
        if (CashMachineCrud.instance == null) {
            CashMachineCrud.instance = new CashMachineCrud();
        }
        return CashMachineCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        CashMachineCrud.instance = null;
    }

    @Override
    public int insert(MCashMachine value) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public MCashMachine update(MCashMachine value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<MCashMachine> getAll(String search) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DBResult<MCashMachine> getFilteredData(int limit, String search) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MCashMachine> getDataByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }  
}
