package com.pokemachine.api.crud;

import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MClientTelephone;
import com.pokemachine.api.utils.SystemUtil;

import java.sql.*;

/**
 * Custumer Telephone Crud
 * @author ivanantunes
 */
public class ClientTelephoneCrud implements DBCrud<MClientTelephone> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static ClientTelephoneCrud instance;

    /**
     * Constructor
     */
    private ClientTelephoneCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static ClientTelephoneCrud getInstance() {

        if (ClientTelephoneCrud.instance == null) {
            ClientTelephoneCrud.instance = new ClientTelephoneCrud();
        }

        return ClientTelephoneCrud.instance;

    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        ClientTelephoneCrud.instance = null;
    }

    @Override
    public int insert(MClientTelephone value) {
        String sql = "INSERT INTO CLIENT_TELEPHONE(CLT_CLI_ID, CLT_TELEPHONE) VALUES(?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, value.getCLT_CLI_ID());
            stmt.setString(2, value.getCLT_TELEPHONE());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();

            int id = 0;

            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Telefone - " + e.getMessage()));
        }

    }

    @Override
    public MClientTelephone update(MClientTelephone value) {
        String sql = "UPDATE CLIENT_TELEPHONE SET CLT_CLI_ID = ?, CLT_TELEPHONE = ? WHERE CLT_ID = ?";

        try {
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, value.getCLT_CLI_ID());
            stmt.setString(2, value.getCLT_TELEPHONE());
            stmt.setInt(3, value.getCLT_ID());

            stmt.executeUpdate();

            return value;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Telefone - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM CLIENT_TELEPHONE WHERE CLT_ID = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Telefone - " + e.getMessage()));
        }
    }

    @Override
    public List<MClientTelephone> getAll(String search) {
        return new ArrayList<MClientTelephone>();
    }

    @Override
    public DBResult<MClientTelephone> getFilteredData(int limit, String search) {
        return new DBResult<MClientTelephone>().setItems(new ArrayList<MClientTelephone>()).setTotalItems(0);
    }

    @Override
    public List<MClientTelephone> getDataByID(int id) {
        String sql = "SELECT * FROM CLIENT_TELEPHONE WHERE CLT_CLI_ID = '" + id + "' OR CLT_ID = '" + id + "'";

        try {
            
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet result = stmt.executeQuery(sql);

            List<MClientTelephone> lTel = new ArrayList<MClientTelephone>();

            while(result.next()) {
                MClientTelephone tel = MClientTelephone.build()
                .setCLT_ID(result.getInt(1))
                .setCLT_CLI_ID(result.getInt(2))
                .setCLT_TELEPHONE(result.getString(3));
                
                lTel.add(tel);
            }

            return lTel;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Telefone - " + e.getMessage()));
        }

    }
    
}
