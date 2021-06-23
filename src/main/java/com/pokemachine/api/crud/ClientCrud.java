package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MClient;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Customer Crud
 * 
 * @author ivanantunes
 */
public class ClientCrud implements DBCrud<MClient> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static ClientCrud instance;

    /**
     * Constructor
     */
    private ClientCrud() {
    }

    /**
     * Get Instance
     * 
     * @return Instance of Class
     */
    public static ClientCrud getInstance() {

        if (ClientCrud.instance == null) {
            ClientCrud.instance = new ClientCrud();
        }

        return ClientCrud.instance;

    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        ClientCrud.instance = null;
    }

    @Override
    public int insert(MClient value) {
        String sql = "INSERT INTO CLIENT (CLI_FULL_NAME, CLI_RG, CLI_CPF, CLI_BIRTHDAY) VALUES(?, ?, ?, ?)";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, value.getCLI_FULL_NAME());
            stmt.setString(2, value.getCLI_RG());
            stmt.setString(3, value.getCLI_CPF());
            stmt.setString(4, value.getCLI_BIRTHDAY());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();

            int id = 0;

            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Cliente - " + e.getMessage()));
        }
    }

    @Override
    public MClient update(MClient value) {
        String sql = "UPDATE CLIENT SET CLI_FULL_NAME = ?, CLI_RG = ?, CLI_CPF = ?, CLI_BIRTHDAY = ? WHERE CLI_ID = ?";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, value.getCLI_FULL_NAME());
            stmt.setString(2, value.getCLI_RG());
            stmt.setString(3, value.getCLI_CPF());
            stmt.setString(4, value.getCLI_BIRTHDAY());
            stmt.setInt(5, value.getCLI_ID());
            stmt.executeUpdate();

            return value;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Cliente - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM CLIENT WHERE CLI_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Cliente - " + e.getMessage()));
        }
    }

    @Override
    public List<MClient> getAll(String search) {
        String sql = "SELECT * FROM CLIENT";

        if (search != null) {
            sql = "SELECT * FROM CLIENT WHERE " + "CLI_FULL_NAME LIKE '%" + search + "%' OR " + "CLI_RG LIKE '%"
                    + search + "%' OR " + "CLI_CPF LIKE '%" + search + "%' OR " + "CLI_BIRTHDAY LIKE '%" + search
                    + "%' OR " + "CLI_ID = '" + search + "'";
        }

        try {
            Statement stmt = this.connection.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            List<MClient> lClient = new ArrayList<MClient>();

            while (result.next()) {
                MClient client = MClient.build().setCLI_ID(result.getInt(1)).setCLI_FULL_NAME(result.getString(2))
                        .setCLI_RG(result.getString(3)).setCLI_CPF(result.getString(4))
                        .setCLI_BIRTHDAY(result.getString(5));

                lClient.add(client);
            }

            return lClient;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Cliente - " + e.getMessage()));
        }
    }

    @Override
    public DBResult<MClient> getFilteredData(int limit, String search) {
        return new DBResult<MClient>().setItems(new ArrayList<MClient>()).setTotalItems(0);
    }

    @Override
    public List<MClient> getDataByID(int id) {

        String sql = "SELECT * FROM CLIENT WHERE CLI_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet result = stmt.executeQuery(sql);

            List<MClient> lClient = new ArrayList<MClient>();

            while (result.next()) {
                MClient client = MClient.build().setCLI_ID(result.getInt(1)).setCLI_FULL_NAME(result.getString(2))
                        .setCLI_RG(result.getString(3)).setCLI_CPF(result.getString(4))
                        .setCLI_BIRTHDAY(result.getString(5));

                lClient.add(client);
            }

            return lClient;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Cliente - " + e.getMessage()));
        }
    }
}
