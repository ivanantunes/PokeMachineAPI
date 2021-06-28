package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MHistoric;
import com.pokemachine.api.models.MHistoric;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Agency Crud
 * 
 * @author LucasZaia
 */
public class HistoricCrud implements DBCrud<MHistoric> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static HistoricCrud instance;

    /**
     * Constructor
     */
    private HistoricCrud() {
    }

    /**
     * Get Instance
     * 
     * @return Instance of Class
     */
    public static HistoricCrud getInstance() {
        if (HistoricCrud.instance == null) {
            HistoricCrud.instance = new HistoricCrud();
        }
        return HistoricCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        HistoricCrud.instance = null;
    }

    @Override
    public int insert(MHistoric value) {

        String sql = "INSERT INTO HISTORIC (HIS_CSM_ID, HIS_ACC_ID, HIS_OPERATION, HIS_DATETIME, HIS_VALUE) VALUES (?,?,?,?,?)";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, value.getHIS_CSM_ID());
            stmt.setInt(2, value.getHIS_ACC_ID());
            stmt.setString(3, value.getHIS_OPERATION());
            stmt.setDate(4, value.getHIS_DATETIME());
            stmt.setFloat(5, value.getHIS_VALUE());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();

            int id = 0;

            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao adicionar Historico") + e.getMessage());
        }
    }

    @Override
    public MHistoric update(MHistoric value) {

        String sql = "UPDATE HISTORIC SET HIS_CSM_ID = ?, HIS_ACC_ID = ?,"
                + "HIS_OPERATION = ?, HIS_DATETIME = ?, HIS_VALUE WHERE HIS_ID = ?";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, value.getHIS_ID());
            stmt.setInt(2, value.getHIS_CSM_ID());
            stmt.setInt(3, value.getHIS_ACC_ID());
            stmt.setString(4, value.getHIS_OPERATION());
            stmt.setDate(5, value.getHIS_DATETIME());
            stmt.setFloat(6, value.getHIS_VALUE());
            stmt.executeUpdate();

            return value;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao atualizar dados do Histórico"));
        }
    }

    @Override
    public void delete(int id) {

        String sql = "DELETE * FROM HISTORIC WHERE HIS_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao excluir Historico"));
        }
    }

    @Override
    public List<MHistoric> getAll(String search) {

        String sql = "SELECT * FROM HISTORIC";

        if (search != null) {
            sql = "SELECT * FROM HISTORIC WHERE " + "HIS_CSM_ID LIKE '% OR" + search + "%' OR" + "HIS_ACC_ID LIKE '%"
                    + search + "%' OR" + "HIS_OPERATION LIKE '%" + search + "%' OR" + "HIS_DATETIME LIKE '%" + search
                    + "%' OR" + "HIS_VALUE LIKE '%" + search + "%' OR" + "HIS_ID ='" + search + "'";
        }
        try {

            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            List<MHistoric> lHistoric = new ArrayList<MHistoric>();

            while (result.next()) {
                MHistoric historic = MHistoric.build().setHIS_ID(result.getInt(1)).setHIS_ACC_ID(result.getInt(2))
                        .setHIS_CSM_ID(result.getInt(3)).setHIS_OPERATION(result.getString(4))
                        .setHIS_DATETIME(result.getDate(5)).setHIS_VALUE(result.getFloat(6));

                lHistoric.add(historic);
            }
            return lHistoric;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Historico" + e.getMessage()));
        }
    }

    @Override
    public DBResult<MHistoric> getFilteredData(int limit, String search) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MHistoric> getDataByID(int id) {

        String sql = "SELECT * FROM HISTORIC WHERE HIS_ID = '" + id + "'";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            List<MHistoric> lHistoric = new ArrayList<MHistoric>();

            while (result.next()) {
                MHistoric historic = MHistoric.build().setHIS_ID(result.getInt(1)).setHIS_ACC_ID(result.getInt(2))
                        .setHIS_CSM_ID(result.getInt(3)).setHIS_OPERATION(result.getString(4))
                        .setHIS_DATETIME(result.getDate(5)).setHIS_VALUE(result.getFloat(6));

                lHistoric.add(historic);
            }

            return lHistoric;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar este Histórico"));
        }
    }

}
