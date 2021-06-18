package com.pokemachine.api.models;

import com.pokemachine.api.enums.EAccount;

/**
 * Account Model
 * @author gbrextreme
 */
public class MAccount {

    /**
     * Account ID 
     */
    private int ACC_ID;

    /**
     * Account Code
     */
    private String ACC_CODE;

    /**
     * Account Password
     */
    private String ACC_PASSWORD;

    /**
     * Account Status
     */
    private Boolean ACC_STATUS;

    /**
     * Account Balance
     */
    private Float ACC_BALANCE;
    
    /**
     * Account Type
     */
    private EAccountType ACC_TYPE; 
    
    /**
     * Private Constructor
     */
    private MAccount() { }

    /**
     * Build Class 
     * @return New Instance of MAccount 
     */
    public static MAccount Build() {
        return new MAccount();
    }

    /**
     * Set ACC_ID
     * @param ACC_ID - Account ID
     * @return Instance of Class
     */
    public MAccount setACC_ID(Int ACC_ID) {
        this.ACC_ID = ACC_ID;
        return this;
    }

    /**
     * Get ACC_ID
     * @return ACC_ID of Account
     */
    public Int getACC_ID() {
        return ACC_ID;
    }

    /**
     * Set ACC_CODE
     * @param ACC_CODE - Account Code
     * @return Instance of Class
     */
    public MAccount setACC_CODE(String ACC_CODE) {
        this.ACC_CODE = ACC_CODE;
        return this;
    }

    /**
     * Get ACC_CODE
     * @return ACC_CODE of Account
     */
    public Int getACC_CODE() {
        return ACC_CODE;
    }

    /**
     * Set ACC_PASSWORD
     * @param ACC_PASSWORD - Account Password
     * @return Instance of Class
     */
    public MAccount setACC_PASSWORD(String ACC_PASSWORD) {
        this.ACC_PASSWORD = ACC_PASSWORD;
        return this;
    }

    /**
     * Get ACC_PASSWORD
     * @return ACC_PASSWORD of Account
     */
    public Int getACC_PASSWORD() {
        return ACC_PASSWORD;
    }

    /**
     * Set ACC_STATUS
     * @param ACC_STATUS - Account Status
     * @return Instance of Class
     */
    public MAccount setACC_STATUS(Boolean ACC_STATUS) {
        this.ACC_STATUS = ACC_STATUS;
        return this;
    }

    /**
     * Get ACC_STATUS
     * @return ACC_STATUS of Account
     */
    public Int getACC_STATUS() {
        return ACC_STATUS;
    }

    /**
     * Set ACC_BALANCE
     * @param ACC_BALANCE - Account Balance
     * @return Instance of Classs
     */
    public MAccount setACC_BALANCE(Float ACC_BALANCE) {
        this.ACC_BALANCE = ACC_BALANCE;
        return this;
    }

    /**
     * Get ACC_BALANCE
     * @return ACC_BALANCE of Account
     */
    public Int getACC_BALANCE() {
        return ACC_BALANCE;
    }

    /**
     * Set ACC_TYPE
     * @param ACC_TYPE - Account Type
     * @return Instance of Class
     */
    public MAccount setACC_TYPE(EAccountType ACC_TYPE) {
        this.ACC_TYPE = ACC_TYPE;
        return this;
    }

    /**
     * Get ACC_TYPE
     * @return ACC_TYPE of Account
     */
    public EAccountType getACC_TYPE() {
        return ACC_TYPE;
    }
}  