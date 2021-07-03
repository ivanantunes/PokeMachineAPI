package com.pokemachine.api.forms;

/**
 * Login Form
 * @author gbrextreme
 */
public class FLogin {

    /**
     * FLogin Code
     */
    private String ACC_CODE;
    
    /**
     * FLogin Password
     */
    private String ACC_PASSWORD;
    
    /**
     * FLogin Cash Machine ID
     */
    private int CSM_ID;
    
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
     * GET Account Code 
     * @return Login Code
     */
    public String getACC_CODE() {
        return ACC_CODE;
    }

    /**
     * SET Account Code
     * @param ACC_CODE - Code of Form
     * @return Instance of Class
     */
    public FLogin setACC_CODE(String ACC_CODE) {
        this.ACC_CODE = ACC_CODE;
        return this;
    }

    /**
     * GET ACC_PASSWORD
     * @return Login Password
     */
    public String getACC_PASSWORD() {
        return ACC_PASSWORD;
    }

    /**
     * SET Password
     * @param ACC_PASSWORD - Password of Form
     * @return Instance of Class
     */
    public FLogin setACC_PASSWORD(String ACC_PASSWORD) {
        this.ACC_PASSWORD = ACC_PASSWORD;
        return this;
    }

    /**
     * GET Cash Machine ID
     * @return Cash Machine ID
     */
    public int getCSM_ID() {
        return CSM_ID;
    }

    /**
     * SET Cash Machine ID
     * @param CSM_ID - ID Cash MAachine of Form
     * @return Instance of Class
     */
    public FLogin setCASH_MACHINE_ID(int CSM_ID) {
        this.CSM_ID = CSM_ID;
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
