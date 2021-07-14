package com.pokemachine.api.forms;

/**
 * Transfer Form
 * @author gbrextreme
 */
public class FTransfer {
    
    /**
     * Destiny Account Code  
     */
    private String account_code;

    /**
     * Value of Transfer
     */
    private float value;

    /**
     * Constructor
     */
    private FTransfer() { }

    /**
     * Build Class
     * @return new instance of FTransfer Form 
     */
    public static FTransfer Build() {
        return new FTransfer();
    }

    /**
     * GET Account Destiny Code
     * @return account_code - Destiny Account Code 
     */
    public String getAccount_code() {
        return account_code;
    }

    /**
     * SET Account Destiny Code
     * @param account_code - Destiny Account Code
     * @return Instance of Class
     */
    public FTransfer setAccount_code(String account_code) {
        this.account_code = account_code;
        return this;
    }

    /**
     * GET Value of Transfer
     * @return value - Value of Transfer
     */
    public float getValue() {
        return value;
    }

    /**
     * SET Value of Transfer
     * @param value - Value
     * @return Instance of Class
     */
    public FTransfer setValue(float value) {
        this.value = value;
        return this;
    }

}
