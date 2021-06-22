package com.pokemachine.api.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Customer Crud
 * 
 * @author ivanantunes
 */
public class AccountCrud implements DBCrud<MAccount> {

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
    private AccountCrud() {
    }

    /**
     * Get Instance
     * 
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

    @Override
    public int insert(MAccount value) {

        String sql = "INSERT INTO ACCOUNT (ACC_AGE_ID,ACC_CODE,ACC_PASSWORD,"
                + "ACC_STATUS,ACC_BALANCE,ACC_TYPE) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, value.getACC_AGE_ID());
            stmt.setInt(2, value.getACC_CLI_ID());

            // TODO gerar random numero da conta

            stmt.setString(3, value.getACC_CODE());
            stmt.setString(4, value.getACC_PASSWORD());
            stmt.setBoolean(5, true);
            stmt.setFloat(6, value.getACC_BALANCE());
            stmt.setString(7, value.getACC_TYPE());
            stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();

            int id = 0;

            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Conta" + e.getMessage()));
        }
    }

    private Random Random() {
        return null;
    }

    @Override
    public MAccount update(MAccount value) {

        String sql = "UPDATE ACCOUNT SET ACC_AGE_ID = ?, ACC_CLI_ID = ?, ACC_CODE = ?, ACC_PASSWORD"
                + "ACC_STATUS = ?, ACC_BALANCE = ?, ACC_TYPE = ? WHERE ACC_ID = ?";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setInt(1, value.getACC_AGE_ID());
            stmt.setInt(2, value.getACC_CLI_ID());
            stmt.setString(3, value.getACC_CODE());
            stmt.setString(4, value.getACC_PASSWORD());
            stmt.setBoolean(5, value.getACC_STATUS());
            stmt.setFloat(6, value.getACC_BALANCE());
            stmt.setString(7, value.getACC_TYPE());
            stmt.setInt(8, value.getACC_ID());
            stmt.executeUpdate();

            return value;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao atualizar dados da conta" + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ACCOUNT WHERE ACC_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Conta"));
        }
    }

    @Override
    public List<MAccount> getAll(String search) {

        String sql = "SELECT * FROM ACCOUNT";

        if (search != null) {
            sql = "SELECT * FROM ACCOUNT WHERE" + "ACC_AGE_ID LIKE '%" + search + "%' OR" + "ACC_CLI_ID LIKE '%"
                    + search + "%' OR" + "ACC_CODE LIKE '%" + search + "%' OR " + "ACC_STATUS LIKE '%" + search
                    + "%' OR" + "ACC_BALANCE LIKE '%" + search + "%' OR" + "ACC_TYPE LIKE '%" + search + "%' OR "
                    + "ACC_ID = '" + search + "'";
        }

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MAccount> lAccount = new ArrayList<MAccount>();

            while (result.next()) {
                MAccount account = MAccount.Build().setACC_ID(result.getInt(1)).setACC_AGE_ID(result.getInt(2))
                        .setACC_CLI_ID(result.getInt(3)).setACC_CODE(result.getString(4))
                        .setACC_PASSWORD(result.getString(5)).setACC_STATUS(result.getBoolean(6))
                        .setACC_BALANCE(result.getFloat(7)).setACC_TYPE(result.getString(8));

                lAccount.add(account);
            }

            return lAccount;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Conta" + e.getMessage()));
        }
    }

    @Override
    public DBResult<MAccount> getFilteredData(int limit, String search) {
        return new DBResult<MAccount>().setItems(new ArrayList<MAccount>()).setTotalItems(0);
    }

    @Override
    public List<MAccount> getDataByID(int id) {

        String sql = "SELECT * FROM ACCOUNT WHERE ACC_ID = '" + id + "'";

        try {

            PreparedStatement stmt = this.connection.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();

            List<MAccount> lAccount = new ArrayList<MAccount>();

            while (result.next()) {
                MAccount account = MAccount.Build().setACC_ID(result.getInt(1)).setACC_AGE_ID(result.getInt(2))
                        .setACC_CLI_ID(result.getInt(3)).setACC_CODE(result.getString(4))
                        .setACC_PASSWORD(result.getString(5)).setACC_STATUS(result.getBoolean(6))
                        .setACC_BALANCE(result.getFloat(7)).setACC_TYPE(result.getString(8));
                lAccount.add(account);
            }
            return lAccount;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao buscar Conta" + e.getMessage()));
        }
    }
}
