package com.pokemachine.api.crud;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.enums.EPartDate;
import com.pokemachine.api.interfaces.DBCrud;
import com.pokemachine.api.models.MCard;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Card Crud
 * @author gbrextreme
 */
public class CardCrud implements DBCrud<MCard> {

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    /**
     * Instance of Class
     */
    private static CardCrud instance;
    
    /**
     * Constructor
     */
    private CardCrud() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static CardCrud getInstance() {

        if (CardCrud.instance == null) {
            CardCrud.instance = new CardCrud();
        }

        return CardCrud.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        CardCrud.instance = null;
    }
    
    @Override
    public int insert(MCard value) {
        String sql = "INSERT INTO CARD (CAR_CODE, CAR_EXPIRATION_DATE, CAR_TYPE, " +
                     "CAR_CVV, CAR_STATUS, CAR_PASSWORD, CAR_LIMIT) VALUES(?,?,?,?,?,?.?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, value.getCAR_ACC_ID());
            stmt.setString(2, value.getCAR_CODE());
            stmt.setString(3, value.getCAR_EXPIRATION_DATE());
            stmt.setString(4, value.getCAR_TYPE());
            stmt.setString(5, value.getCAR_CVV());
            stmt.setBoolean(6, value.getCAR_STATUS());
            stmt.setString(7, value.getCAR_PASSWORD());
            stmt.setFloat(8, value.getCAR_LIMIT());
            stmt.executeUpdate();   

            ResultSet result = stmt.getGeneratedKeys();
            
            int id = 0;
            if (result.next()) {
                id = result.getInt(1);
            }

            return id;

        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Cadastrar Cartao - " + err.getMessage()));
        }
    }

    @Override
    public MCard update(MCard value) {
        String sql = "UPDATE CARD SET CAR_ACC_ID = ?, CAR_CODE = ?, CAR_EXPIRATION_DATE = ?, CAR_TYPE = ?, " +
                     "CAR_CVV = ?, CAR_STATUS = ?, CAR_PASSWORD = ? , CAR_LIMIT = ? WHERE CAR_ID = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, value.getCAR_ACC_ID());
            stmt.setString(2, value.getCAR_CODE());
            stmt.setString(3, value.getCAR_EXPIRATION_DATE());
            stmt.setString(4, value.getCAR_TYPE());
            stmt.setString(5, value.getCAR_CVV());
            stmt.setBoolean(6, value.getCAR_STATUS());
            stmt.setString(7, value.getCAR_PASSWORD());
            stmt.setFloat(8, value.getCAR_LIMIT());
            stmt.setInt(9, value.getCAR_ID());
            stmt.executeUpdate();   

            return value;
        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Atualizar Cartao - " + err.getMessage()));
        }
    }

    @Override
    public void delete(int id) {
        String sql = "UPDATE CARD SET STATUS = False WHERE CAR_CLI = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception  err) {
            throw new Error(SystemUtil.log("Falha ao Deletar Cartao - " + err.getMessage()));
        }

    }

    @Override
    public List<MCard> getAll(String search) {
        return null;
    }

    @Override
    public DBResult<MCard> getFilteredData(int limit, String search) {
        String sqlCount = "SEELCT COUNT(*) AS TOTAL FROM CARD";
        String sql = "SELECT * FROM CARD CAR_ID LIMIT " + limit;
        
        if (search != null) {
            sql = "SELECT * FROM CARD WHERE " +
            "CAR_ID LIKE '%"+search+"%' OR " +
            "CAR_ACC_ID LIKE '%"+search+"%' OR " +
            "CAR_CODE LIKE '"+search+"%' OR"+
            "CAR_EXPIRATION_DATE LIKE '"+search+"%' OR"+
            "CAR_TYPE LIKE '"+search+"%' OR"+
            "CAR_CVV LIKE '"+search+"%' OR"+
            "CAR_STATUS LIKE '"+search+"%' OR"+
            "CAR_PASSWORD LIKE '"+search+"%' OR"+
            "CAR_LIMIT LIKE '"+search+"%' LIMIT "+limit;

            sqlCount = "SELECT COUNT(*) AS TOTAL FROM CARD WHERE " +
            "CAR_ID LIKE '%"+search+"%' OR " +
            "CAR_ACC_ID LIKE '%"+search+"%' OR " +
            "CAR_CODE LIKE '"+search+"%' OR"+
            "CAR_EXPIRATION_DATE LIKE '"+search+"%' OR"+
            "CAR_TYPE LIKE '"+search+"%' OR"+
            "CAR_CVV LIKE '"+search+"%' OR"+
            "CAR_STATUS LIKE '"+search+"%' OR"+
            "CAR_PASSWORD LIKE '"+search+"%' OR"+
            "CAR_LIMIT LIKE '"+search+"%' LIMIT "+limit;
        }

        try {
            Statement stmt1 = this.connection.createStatement();
            Statement stmt2 = this.connection.createStatement();

            ResultSet resultTotal = stmt1.executeQuery(sqlCount);
            ResultSet result = stmt2.executeQuery(sql);
            
            List<MCard> lCard = new ArrayList<MCard>();
            int total =  0;

            while (result.next()) {
                MCard card = MCard.Build()
                    .setCAR_ID(result.getInt(1))
                    .setCAR_ACC_ID(result.getInt(2))
                    .setCAR_CODE(result.getString(3))
                    .setCAR_EXPIRATION_DATE(result.getString(4))
                    .setCAR_TYPE(result.getString(5))
                    .setCAR_CVV(result.getString(6))
                    .setCAR_STATUS(result.getBoolean(7))
                    .setCAR_PASSWORD(result.getString(8))
                    .setCAR_LIMIT(result.getFloat(9));
                lCard.add(card);
            }

            if (resultTotal.next()) {
                total = resultTotal.getInt(1);
            }

            return new DBResult<MCard>().setItems(lCard).setTotalItems(total);
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Cartão - " + e.getMessage()));
        }

    }

    @Override
    public List<MCard> getDataByID(int id) {
        String sql = "SELECT * FROM CARD WHERE CAR_ID = '" + id + "'";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            List<MCard> LCard = new ArrayList<MCard>();

            while(result.next()) {
                MCard card = MCard.Build()
                    .setCAR_ID(result.getInt(1))
                    .setCAR_ACC_ID(result.getInt(2))
                    .setCAR_CODE(result.getString(3))
                    .setCAR_EXPIRATION_DATE(result.getString(4))
                    .setCAR_TYPE(result.getString(5))
                    .setCAR_CVV(result.getString(6))
                    .setCAR_STATUS(result.getBoolean(7))
                    .setCAR_PASSWORD(result.getString(8))
                    .setCAR_LIMIT(result.getFloat(9));
                LCard.add(card);
            }

            return LCard;
        } catch (Exception e) {
            throw new Error(SystemUtil.log("Falha ao Buscar Cartão - " + e.getMessage()));
        }
    }

    public int AskCard(MCard value) {
        String sql = "INSERT INTO CARD (CAR_CODE, CAR_EXPIRATION_DATE, CAR_TYPE, " +
                     "CAR_CVV, CAR_STATUS, CAR_PASSWORD) VALUES(?,?,?,?,?,?)";

        MCard data = MCard.Build()
            .setCAR_ACC_ID(value.getCAR_ACC_ID())
            .setCAR_TYPE(value.getCAR_TYPE())
            .setCAR_PASSWORD(value.getCAR_PASSWORD())
            .setCAR_LIMIT(value.getCAR_LIMIT());

        try {

            BigInteger minCode = new BigInteger("100000000000000");
            BigInteger maxCode = new BigInteger("99999999999999999999");
            data.setCAR_CODE(String.valueOf(SystemUtil.randomNumber(minCode, maxCode)));
            
            BigInteger minCvv = new BigInteger("100");
            BigInteger maxCvv = new BigInteger("999");
            String CAR_CVV = String.valueOf(SystemUtil.randomNumber(minCvv, maxCvv));
            data.setCAR_CVV(CAR_CVV);
            
            data.setCAR_EXPIRATION_DATE(
                SystemUtil.takePartOfDate(EPartDate.MONTH, 0)+"/"+ 
                SystemUtil.takePartOfDate(EPartDate.YEAR, 8));

            data.setCAR_STATUS(true);

            try {
                PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, data.getCAR_ACC_ID());
                stmt.setString(2, data.getCAR_CODE());
                stmt.setString(3, data.getCAR_EXPIRATION_DATE());
                stmt.setString(4, data.getCAR_TYPE());
                stmt.setString(5, data.getCAR_CVV());
                stmt.setBoolean(6, data.getCAR_STATUS());
                stmt.setString(7, data.getCAR_PASSWORD());
                stmt.setFloat(8, data.getCAR_LIMIT());
                stmt.executeUpdate();   
    
                ResultSet result = stmt.getGeneratedKeys();
                
                int id = 0;
                if (result.next()) {
                    id = result.getInt(1);
                }

                return id;
            } catch (Exception  err) {
                throw new Error(SystemUtil.log("Falha ao Cadastrar Cartao - " + err.getMessage()));
            }

        } catch (Exception err) {
            throw new Error(SystemUtil.log("Falha ao Gerar Dados para Cartao - " + err.getMessage()));    
        }
            
    } 

}