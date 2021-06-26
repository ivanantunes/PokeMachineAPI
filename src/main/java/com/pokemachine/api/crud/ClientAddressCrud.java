package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MClientAddress;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Client Address Crud
 * @author gbrextreme
 */
public class ClientAddressCrud implements DBCrud<MClientAddress> {
    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static ClientAddressCrud instance;
    
    /**
     * Constructor
     */
    private ClientAddressCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static ClientAddressCrud getInstance() {
        if (ClientAddressCrud.instance == null) {
            ClientAddressCrud.instance = new ClientAddressCrud();
        }
        return ClientAddressCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        ClientAddressCrud.instance = null;
    }

    @Override
    public int insert(MClientAddress value) {
        String sql = "INSERT INTO CLIENT_ADDRESS (CLA_CLI_ID, CLA_ZIP_CODE, CLA_ADDRESS, CLA_NUMBER, CLA_DISTRICTY, CLA_CITY, CLA_UF)" +
                     "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, value.getCLA_CLI_ID());
            stmt.setString(2, value.getCLA_ZIP_CODE());
            stmt.setString(3, value.getCLA_ADDRESS());
            stmt.setInt(4, value.getCLA_NUMBER());
            stmt.setString(5, value.getCLA_DISTRICTY());
            stmt.setString(6, value.getCLA_CITY());
            stmt.setString(7, value.getCLA_UF());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }

            return id;
        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Endereço de Cliente - " + err.getMessage()));
        }
    }

    @Override
    public MClientAddress update(MClientAddress value) {
        String sql = "UPDATE CLIENT_ADDRESS SET CLA_CLI_ID = ?, CLA_ZIP_CODE = ?, CLA_ADDRESS = ?," +
                     "CLA_NUMBER = ?, CLA_DISTRICTY = ?, CLA_CITY = ?, CLA_UF = ? WHERE CLA_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, value.getCLA_CLI_ID());
            stmt.setString(2, value.getCLA_ZIP_CODE());
            stmt.setString(3, value.getCLA_ADDRESS());
            stmt.setInt(4, value.getCLA_NUMBER());
            stmt.setString(5, value.getCLA_DISTRICTY());
            stmt.setString(6, value.getCLA_CITY());
            stmt.setString(7, value.getCLA_UF());
            stmt.setInt(8, value.getCLA_ID());
            stmt.executeUpdate(); 

            return value;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Endereço de Cliente - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM CLIENT_ADDRESS WHERE CLA_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Endereço de Cliente - " + e.getMessage()));
        }
    }

    @Override
    public List<MClientAddress> getAll(String search) {
        String sql = "SELECT * FROM CLIENT_ADDRESS";

        if (search != null) {
            sql = "SELECT * FROM CLIENT_ADDRESS WHERE " +
            "CLA_ZIP_CODE LIKE '%" + search + "%' OR " +
            "CLA_ADDRESS LIKE '%" + search + "%' OR " +
            "CLA_NUMBER LIKE '%" + search + "%' OR " +
            "CLA_DISTRICTY LIKE '%" + search + "%' OR " +
            "CLA_CITY LIKE '%" + search + "%' OR " +
            "CLA_UF LIKE '%" + search + "%' OR " +
            "CLA_CLI_ID = '%" + search + "%' OR " +
            "CLA_ID = '" + search + "'";
        }

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MClientAddress> lClientAddresses = new ArrayList<MClientAddress>();

            while(result.next()) {
                MClientAddress clientAddress = MClientAddress.Build()
                    .setCLA_ID(result.getInt(1))
                    .setCLA_CLI_ID(result.getInt(2))
                    .setCLA_ZIP_CODE(result.getString(3))
                    .setCLA_ADDRESS(result.getString(4))
                    .setCLA_NUMBER(result.getInt(5))
                    .setCLA_DISTRICTY(result.getString(6))
                    .setCLA_CITY(result.getString(7))
                    .setCLA_UF(result.getString(8));    
                lClientAddresses.add(clientAddress);
            }

            return lClientAddresses;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Endereço de Cliente - " + e.getMessage()));
        }
    }

    @Override
    public DBResult<MClientAddress> getFilteredData(int limit, String search) {
        return null;
    }

    @Override
    public List<MClientAddress> getDataByID(int id) {
        String sql = "SELECT * FROM CLIENT_ADDRESS WHERE CLA_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MClientAddress> lClientAddress = new ArrayList<MClientAddress>();

            while(result.next()) {
                MClientAddress clientAddress = MClientAddress.Build()
                    .setCLA_ID(result.getInt(1))
                    .setCLA_CLI_ID(result.getInt(2))
                    .setCLA_ZIP_CODE(result.getString(3))
                    .setCLA_ADDRESS(result.getString(4))
                    .setCLA_NUMBER(result.getInt(5))
                    .setCLA_DISTRICTY(result.getString(6))
                    .setCLA_CITY(result.getString(7))
                    .setCLA_UF(result.getString(8));
                lClientAddress.add(clientAddress);
            }

            return lClientAddress;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Endereço de Cliente - " + e.getMessage()));
        }
    }
    
}
