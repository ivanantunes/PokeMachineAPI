package com.pokemachine.api.crud;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MBank;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Customer Crud
 * 
 * @author LucasZaia
 */
public class BankCrud implements DBCrud<MBank> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static BankCrud instance;

    /**
     * Constructor
     */
    private BankCrud() {
    }

    /**
     * Get Instance
     * 
     * @return Instance of Class
     */
    public static BankCrud getInstance() {

        if (BankCrud.instance == null) {
            BankCrud.instance = new BankCrud();
        }

        return BankCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        BankCrud.instance = null;
    }

    @Override
    public int insert(MBank value) {

        String sql = "INSERT INTO BANK (BNK_NAME,BNK_CODE) VALUES (BNK_NAME = ?, BNK_CODE = ?)";

        try {

            BigInteger min = new BigInteger("10000");
            BigInteger max = new BigInteger("99999");
            value.setBNK_CODE(String.valueOf(SystemUtil.randomNumber(min, max)));

            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, value.getBNK_NAME());
                stmt.setString(2, value.getBNK_CODE());
                stmt.executeUpdate();

                ResultSet result = stmt.getGeneratedKeys();

                int id = 0;

                if (result.next()) {
                    id = result.getInt(1);
                }

                return id;
            } catch (Exception e) {
                throw new Error(SystemUtil.log("Falha ao cadastrar Banco" + e.getMessage()));
            }
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao gerar Banco" + e.getMessage()));
        }
    }

    @Override
    public MBank update(MBank value) {

        String sql = "  UPDATE BANK SET BNK_NAME = ?, BNK_CODE WHERE BNK_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, value.getBNK_NAME());
            stmt.setString(2, value.getBNK_CODE());
            stmt.setInt(3, value.getBNK_ID());
            stmt.executeUpdate();

            return value;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao atualizar dados de Banco" + e.getMessage()));
        }
    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM BANK WHERE BNK_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Deletar Banco" + e.getMessage()));
        }
    }

    @Override
    public List<MBank> getAll(String search) {

        String sql = "SELECT * FROM BANK";

        if (search != null) {
            sql = "SELECT * FROM BANK WHERE " + "BNK_NAME LIKE '%" + search + "' OR" + "BNK_CODE LIKE '%" + search
                    + "'";
        }

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            List<MBank> lBank = new ArrayList<MBank>();

            while (result.next()) {
                MBank bank = MBank.build().setBNK_ID(result.getInt(1)).setBNK_NAME(result.getString(2))
                        .setBNK_CODE(result.getString(3));

                lBank.add(bank);
            }

            return lBank;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao buscar Banco"));
        }
    }

    @Override
    public DBResult<MBank> getFilteredData(int limit, String search) {
        return null;
    }

    @Override
    public List<MBank> getDataByID(int id) {
        String sql = "SELECT * FROM BANK WHERE BNK_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            List<MBank> lBank = new ArrayList<MBank>();

            while (result.next()) {
                MBank bank = MBank.build().setBNK_ID(result.getInt(1)).setBNK_NAME(result.getString(2))
                        .setBNK_CODE(result.getString(3));

                lBank.add(bank);

            }

            return lBank;

        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao buscar Banco"));
        }
    }
}
