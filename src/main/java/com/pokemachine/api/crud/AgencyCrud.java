package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MAgency;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Agency Crud
 * @author gbrextreme
 */
public class AgencyCrud implements DBCrud<MAgency> {
    
    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static AgencyCrud instance;
    
    /**
     * Constructor
     */
    private AgencyCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static AgencyCrud getInstance() {
        if (AgencyCrud.instance == null) {
            AgencyCrud.instance = new AgencyCrud();
        }
        return AgencyCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        AgencyCrud.instance = null;
    }

    @Override
    public int insert(MAgency value) {
        String sql = "INSERT INTO AGENCY (AGE_BNK_ID, AGE_NAME, AGE_CODE) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, value.getAGE_BNK_ID());
            stmt.setString(2, value.getAGE_NAME());
            stmt.setString(3, value.getAGE_CODE());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Agencia - " + err.getMessage()));
        }
    }

    @Override
    public MAgency update(MAgency value) {
        String sql = "UPDATE AGENCY SET AGE_BNK_ID = ?, AGE_NAME = ?, AGE_CODE = ? WHERE AGE_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, value.getAGE_BNK_ID());
            stmt.setString(2, value.getAGE_NAME());
            stmt.setString(3, value.getAGE_CODE());
            stmt.setInt(4, value.getAGE_ID());
            stmt.executeUpdate(); 

            return value;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Agencia - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM AGENCY WHERE AGE_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Agencia - " + e.getMessage()));
        }
    }

    @Override
    public List<MAgency> getAll(String search) {
        String sql = "SELECT * FROM AGENCY";

        if (search != null) {
            sql = "SELECT * FROM AGENCY WHERE " +
            "AGE_NAME LIKE '%" + search + "%' OR " +
            "AGE_CODE LIKE '%" + search + "%' OR " +
            "AGE_BNK_ID = '" + search + "' OR " + 
            "AGE_ID = '" + search + "'";
        }

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MAgency> lAgencies = new ArrayList<MAgency>();

            while(result.next()) {
                MAgency agency = MAgency.Build()
                    .setAGE_ID(result.getInt(1))
                    .setAGE_BNK_ID(result.getInt(2))
                    .setAGE_NAME(result.getString(3))
                    .setAGE_CODE(result.getString(4));
                lAgencies.add(agency);
            }

            return lAgencies;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Agencia - " + e.getMessage()));
        }
    }

    @Override
    public DBResult<MAgency> getFilteredData(int limit, String search) {
        return null;
    }

    @Override
    public List<MAgency> getDataByID(int id) {
        String sql = "SELECT * FROM AGENCY WHERE AGE_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MAgency> lAgencies = new ArrayList<MAgency>();

            while(result.next()) {
                MAgency card = MAgency.Build()
                    .setAGE_ID(result.getInt(1))
                    .setAGE_BNK_ID(result.getInt(2))
                    .setAGE_NAME(result.getString(3))
                    .setAGE_CODE(result.getString(4));
                lAgencies.add(card);
            }

            return lAgencies;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Agencia - " + e.getMessage()));
        }
    }

    public List<MAgency> getDataByCode(String code) {
        String sql = "SELECT * FROM AGENCY WHERE AGE_CODE = '" + code + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MAgency> lAgencies = new ArrayList<MAgency>();

            while(result.next()) {
                MAgency card = MAgency.Build()
                    .setAGE_ID(result.getInt(1))
                    .setAGE_BNK_ID(result.getInt(2))
                    .setAGE_NAME(result.getString(3))
                    .setAGE_CODE(result.getString(4));
                lAgencies.add(card);
            }

            return lAgencies;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Agencia - " + e.getMessage()));
        }
    }
}
