package com.pokemachine.api.forms;

/**
 * Login Form
 * @author gbrextreme
 */
public class FLogin {

    /**
     * FLogin Code
     */
    private String CODE;
    
    /**
     * FLogin Password
     */
    private String PASSWORD;
    
    /**
     * FLogin Cash Machine ID
     */
    private int CASH_MACHINE_ID;
    
    /**
     * FLogin token
     */
    private String TOKEN;

    /**
     * Constructor
     */
    private FLogin () { }

    /**
     * Build Class
     * @return New instance fo Class FLogin
     */
    public static FLogin Build() {
        return new FLogin();
    }

    /**
     * GET Code 
     * @return Login Code
     */
    public String getCODE() {
        return CODE;
    }

    /**
     * SET Code
     * @param CODE - Code of Form
     * @return Instance of Class
     */
    public FLogin setCODE(String CODE) {
        this.CODE = CODE;
        return this;
    }

    /**
     * GET Password
     * @return Login Password
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * SET Password
     * @param PASSWORD - Password of Form
     * @return Instance of Class
     */
    public FLogin setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
        return this;
    }

    /**
     * GET Cash Machine ID
     * @return Cash Machine ID
     */
    public int getCASH_MACHINE_ID() {
        return CASH_MACHINE_ID;
    }

    /**
     * SET Cash Machine ID
     * @param CASH_MACHINE_ID - ID Cash MAachine of Form
     * @return Instance of Class
     */
    public FLogin setCASH_MACHINE_ID(int CASH_MACHINE_ID) {
        this.CASH_MACHINE_ID = CASH_MACHINE_ID;
        return this;
    }

    /**
     * GET Token
     * @return Token
     */
    public String getTOKEN() {
        return TOKEN;
    }

    /**
     * SET Token
     * @param TOKEN - Token of Form
     * @return Instance of Class
     */
    public FLogin setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
        return this;
    }

}
