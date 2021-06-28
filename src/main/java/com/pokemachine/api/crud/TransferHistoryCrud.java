package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MTransferHistory;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Agency Crud
 * @author gbrextreme
 */
public class TransferHistoryCrud implements DBCrud<MTransferHistory> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static TransferHistoryCrud instance;

    /**
     * Constructor
     */
    private TransferHistoryCrud() {
    }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static TransferHistoryCrud getInstance() {
        if (TransferHistoryCrud.instance == null) {
            TransferHistoryCrud.instance = new TransferHistoryCrud();
        }
        return TransferHistoryCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        TransferHistoryCrud.instance = null;
    }

    @Override
    public int insert(MTransferHistory value) {
        String sql = "INSERT INTO TRANSFER_HISTORY (TRH_ORIGIN_ACC_ID, TRH_DESTINY_ACC_ID, TRH_VALUE, "+
                    "TRH_DATETME) VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, value.getTRH_ORIGIN_ACC_ID());
            stmt.setInt(2, value.getTRH_DESTINY_ACC_ID());
            stmt.setFloat(3, value.getTRH_VALUE());
            stmt.setString(4, value.getTRH_DATETIME());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }

            return id;
        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Historico de Transferencia - " + err.getMessage()));
        }
    }

    @Override
    public MTransferHistory update(MTransferHistory value) {
        String sql = "UPDATE TRANSFER_HISTORY SET TRH_ORIGIN_ACC_ID = ?, TRH_DESTINY_ACC_ID = ?, TRH_VALUE = ?, "+
        "TRH_DATETME = ? WHERE TRH_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, value.getTRH_ORIGIN_ACC_ID());
            stmt.setInt(2, value.getTRH_DESTINY_ACC_ID());
            stmt.setFloat(3, value.getTRH_VALUE());
            stmt.setString(4, value.getTRH_DATETIME());
            stmt.setInt(5, value.getTRH_ID());
            stmt.executeUpdate(); 

            return value;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Historico Transferencia - " + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM TRANSFER_HISTORY WHERE TRH_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Historico Transferencia - " + e.getMessage()));
        }   
    }

    @Override
    public List<MTransferHistory> getAll(String search) {
        String sql = "SELECT * FROM TRANSFER_HISTORY";

        if (search != null) {
            sql = "SELECT * FROM TRANSFER_HISTORY WHERE " +
            "TRH_VALUE = '" + search + "' OR " +
            "TRH_DATETIME = '" + search + "' OR " +
            "TRH_ORIGIN_ACC_ID = '" + search + "' OR " + 
            "TRH_DESTINY_ACC_ID = '" + search + "' OR " +
            "TRH_ID = '" + search + "'";

        }

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MTransferHistory> lTransferHistories = new ArrayList<MTransferHistory>();

            while(result.next()) {
                MTransferHistory agency = MTransferHistory.Build()
                    .setTRH_ID(result.getInt(1))
                    .setTRH_ORIGIN_ACC_ID(result.getInt(2))
                    .setTRH_ORIGIN_ACC_ID(result.getInt(3))
                    .setTRH_VALUE(result.getFloat(4))
                    .setTRH_DATETIME(result.getString(5));
                    lTransferHistories.add(agency);
            }

            return lTransferHistories;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Historico de Transferencia - " + e.getMessage()));
        }
    }

    @Override
    public DBResult<MTransferHistory> getFilteredData(int limit, String search) {
        return null;
    }

    @Override
    public List<MTransferHistory> getDataByID(int id) {
        String sql = "SELECT * FROM TRANSFER_HISTORY WHERE TRH_ID = '" + id + "'";

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MTransferHistory> lTransferHistories = new ArrayList<MTransferHistory>();

            while(result.next()) {
                MTransferHistory agency = MTransferHistory.Build()
                    .setTRH_ID(result.getInt(1))
                    .setTRH_ORIGIN_ACC_ID(result.getInt(2))
                    .setTRH_ORIGIN_ACC_ID(result.getInt(3))
                    .setTRH_VALUE(result.getFloat(4))
                    .setTRH_DATETIME(result.getString(5));
                    lTransferHistories.add(agency);
            }

            return lTransferHistories;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Historico de Transferencia - " + e.getMessage()));
        }
    }
    
}
