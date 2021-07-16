package com.pokemachine.api.database;

import java.sql.*;

import com.pokemachine.api.configs.DBConfig;
import com.pokemachine.api.utils.SystemUtil;

/**
 * Class Database Service
 * 
 * @author ivanantunes
 */
public class DBService {

    /**
     * Keeps the Class Instance
     */
    private static DBService instance;

    /**
     * Keeps the Connection Database
     */
    private Connection connection;

    /**
     * Constructor
     */
    private DBService() {

        try {

            SystemUtil.log("Conectando ao Banco de Dado.");

            String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            this.connection = DriverManager.getConnection(DBConfig.url + "?" + unicode, DBConfig.user, DBConfig.password);

            SystemUtil.log("Conexão Realizada com Sucesso.");

            SystemUtil.log("Testando Conexão com o Banco de Dados.");

            Statement stmt = this.connection.createStatement();

            ResultSet result = stmt.executeQuery("SELECT (1+1) AS SUM FROM DUAL");

            while (result.next()) {
                SystemUtil.log("Resultado do Teste 1 + 1 = " + result.getInt(1));
            }

            SystemUtil.log("Teste Realizado com Sucesso.");

            SystemUtil.log("Serviço Liberado Para Uso.");

        } catch (Exception e) {

            SystemUtil.log("Falha ao Efetuar Conexão com Banco de Dados - " + e.getMessage());

        }

    }

    /**
     * Get Instance of Class
     * 
     * @return Class of DBService
     */
    public static DBService getInstance() {
        if (DBService.instance == null) {
            DBService.instance = new DBService();
        }

        return DBService.instance;
    }

    /**
     * Destroy Instance of Class
     */
    public static void destroyInstance() {
        DBService.instance = null;
    }

    /**
     * Get Connection
     * @return Connection of Database
     */
    public Connection getConnection() {
        return connection;
    }

}
