package com.pokemachine.api.models;

/**
 * Account Model
 * 
 * @author gbrextreme
 */
public class MAccount {

    /**
     * Account ID
     */
    private int ACC_ID = 0;

    /**
     * Accout Client ID
     */
    private int ACC_CLI_ID = 0;

    /**
     * Account Agency ID
     */
    private int ACC_AGE_ID = 0;

    /**
     * Account Code
     */
    private String ACC_CODE = "";

    /**
     * Account Password
     */
    private String ACC_PASSWORD = "";

    /**
     * Account Status
     */
    private boolean ACC_STATUS = false;

    /**
     * Account Balance
     */
    private float ACC_BALANCE = 0;

    /**
     * Account Type
     */
    private String ACC_TYPE;

    /**
     * Private Constructor
     */
    private MAccount() {
    }

    /**
     * Build Class
     * 
     * @return New Instance of MAccount
     */
    public static MAccount Build() {
        return new MAccount();
    }

    /**
     * Set ACC_ID
     * 
     * @param ACC_ID - Account ID
     * @return Instance of Class
     */
    public MAccount setACC_ID(int ACC_ID) {
        this.ACC_ID = ACC_ID;
        return this;
    }

    /**
     * Get ACC_ID
     * 
     * @return ACC_ID of Account
     */
    public int getACC_ID() {
        return ACC_ID;
    }

    /**
     * Set ACC_CLI_ID
     * 
     * @param ACC_CLI_ID - Account Client ID
     * @return Instance of Class
     */
    public MAccount setACC_CLI_ID(int ACC_CLI_ID) {
        this.ACC_CLI_ID = ACC_CLI_ID;
        return this;
    }

    /**
     * Get ACC_CLI_ID
     * 
     * @return ACC_CLI_ID of Account
     */
    public int getACC_CLI_ID() {
        return ACC_CLI_ID;
    }

    /**
     * Set ACC_AGE_ID
     * 
     * @param ACC_AGE_ID - Account Agency ID
     * @return Instance of Class
     */
    public MAccount setACC_AGE_ID(int ACC_AGE_ID) {
        this.ACC_AGE_ID = ACC_AGE_ID;
        return this;
    }

    /**
     * Get ACC_AGE_ID
     * 
     * @return ACC_AGE_ID of Account
     */
    public int getACC_AGE_ID() {
        return ACC_AGE_ID;
    }

    /**
     * Set ACC_CODE
     * 
     * @param ACC_CODE - Account Code
     * @return Instance of Class
     */
    public MAccount setACC_CODE(String ACC_CODE) {
        this.ACC_CODE = ACC_CODE;
        return this;
    }

    /**
     * Get ACC_CODE
     * 
     * @return ACC_CODE of Account
     */
    public String getACC_CODE() {
        return ACC_CODE;
    }

    /**
     * Set ACC_PASSWORD
     * 
     * @param ACC_PASSWORD - Account Password
     * @return Instance of Class
     */
    public MAccount setACC_PASSWORD(String ACC_PASSWORD) {
        this.ACC_PASSWORD = ACC_PASSWORD;
        return this;
    }

    /**
     * Get ACC_PASSWORD
     * 
     * @return ACC_PASSWORD of Account
     */
    public String getACC_PASSWORD() {
        return ACC_PASSWORD;
    }

    /**
     * Set ACC_STATUS
     * 
     * @param ACC_STATUS - Account Status
     * @return Instance of Class
     */
    public MAccount setACC_STATUS(boolean ACC_STATUS) {
        this.ACC_STATUS = ACC_STATUS;
        return this;
    }

    /**
     * Get ACC_STATUS
     * 
     * @return ACC_STATUS of Account
     */
    public boolean getACC_STATUS() {
        return ACC_STATUS;
    }

    /**
     * Set ACC_BALANCE
     * 
     * @param ACC_BALANCE - Account Balance
     * @return Instance of Classs
     */
    public MAccount setACC_BALANCE(float ACC_BALANCE) {
        this.ACC_BALANCE = ACC_BALANCE;
        return this;
    }

    /**
     * Get ACC_BALANCE
     * 
     * @return ACC_BALANCE of Account
     */
    public float getACC_BALANCE() {
        return ACC_BALANCE;
    }

    /**
     * Set ACC_TYPE
     * 
     * @param ACC_TYPE - Account Type
     * @return Instance of Class
     */
    public MAccount setACC_TYPE(String ACC_TYPE) {
        this.ACC_TYPE = ACC_TYPE;
        return this;
    }

    /**
     * Get ACC_TYPE
     * 
     * @return ACC_TYPE of Account
     */
    public String getACC_TYPE() {
        return ACC_TYPE;
    }
}