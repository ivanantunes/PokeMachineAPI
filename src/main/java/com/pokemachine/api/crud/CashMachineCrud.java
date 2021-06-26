package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.utils.SystemUtil;

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
        String sql = "INSERT INTO CASH_MACHINE (CSM_NAME, CSM_AVAILABLE_VALUE) VALUES(?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, value.getCSM_NAME());
            stmt.setFloat(2, value.getCSM_AVAILABLE_VALUE());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }

            return id;
        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Caixa Eletrônico - " + err.getMessage()));
        }
    }

    @Override
    public MCashMachine update(MCashMachine value) {
        String sql = "UPDATE CASH_MACHINE SET CSM_NAME = ?, CSM_AVAILABLE_VALUE = ? WHERE CSM_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, value.getCSM_NAME());
            stmt.setFloat(2, value.getCSM_AVAILABLE_VALUE());
            stmt.setInt(3, value.getCSM_ID());
            stmt.executeUpdate(); 

            return value;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Caixa Eletrônico - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM CASH_MACHINE WHERE CSM_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Caixa Eletrônico - " + e.getMessage()));
        }
    }

    @Override
    public List<MCashMachine> getAll(String search) {
        String sql = "SELECT * FROM CASH_MACHINE";

        if (search != null) {
            sql = "SELECT * FROM CASH_MACHINE WHERE " +
            "CSM_NAME LIKE '%" + search + "%' OR " +
            "CSM_AVAILABLE_VALUE LIKE '%" + search + "%' OR " +
            "CSM_ID = '" + search + "'";
        }

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MCashMachine> lCashMachines = new ArrayList<MCashMachine>();

            while(result.next()) {
                MCashMachine cashMachine = MCashMachine.Build()
                    .setCSM_ID(result.getInt(1))
                    .setCSM_NAME(result.getString(2))
                    .setCSM_AVAILABLE_VALUE(result.getFloat(3));
                lCashMachines.add(cashMachine);
            }

            return lCashMachines;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Caixa Eletrônico - " + e.getMessage()));
        }
    }

    @Override
    public DBResult<MCashMachine> getFilteredData(int limit, String search) {
        return null;
    }

    @Override
    public List<MCashMachine> getDataByID(int id) {
        String sql = "SELECT * FROM CASH_MACHINE WHERE CSM_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MCashMachine> lCashMachines = new ArrayList<MCashMachine>();

            while(result.next()) {
                MCashMachine cashMachine = MCashMachine.Build()
                    .setCSM_ID(result.getInt(1))
                    .setCSM_NAME(result.getString(2))
                    .setCSM_AVAILABLE_VALUE(result.getFloat(3));
                lCashMachines.add(cashMachine);
            }

            return lCashMachines;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Agencia - " + e.getMessage()));
        }
    }  
}
