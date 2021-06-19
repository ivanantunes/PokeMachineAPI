package com.pokemachine.api.models;

/**
 * Customer Model
 * author LucasZaia
 */
public class MBank {

    /**
     * Bank ID
     */
    private int BNK_ID = 0;

    /**
     * Bank Name
     */
    private String BNK_NAME = "";

    /**
     * Bank Code
     */
    private String BNK_CODE = "";

    /**
     * Constructor
     */
    private MBank () {}

    /**
     * Build Class
     * @return instance of Class
     */
    public static MBank build () {
        return new MBank();
    }
    
    /**
     * Get BNK_ID
     * @return BNK_ID of Bank
     */
    public int getBNK_ID () {
        return BNK_ID;
    }

    /**
     * Set BNK_ID
     * @param BNK_ID - ID of Bank
     * @return instance of Class
     */
    public MBank setBNK_ID (int BNK_ID) {
        this.BNK_ID = BNK_ID;
        return this;
    }

    /**
     * Get BNK_NAME
     * @return BNK_NAME of Bank
     */
    public String getBNK_NAME () {
        return BNK_NAME;
    }

    /**
     * Set BNK_NAME
     * @param BNK_NAME - Bank Name
     * @return instance of Class
     */
    public MBank setBNK_NAME (String BNK_NAME) {
        this.BNK_NAME = BNK_NAME;
        return this;
    }

    /**
     * Get BNK_CODE
     * @return BNK_CODE of Bank
     */
    public String getBNK_CODE () {
        return BNK_CODE;
    }

    /**
     * Set BNK_CODE
     * @param BNK_CODE - Bank Code 
     * @return instance of Class
     */
    public MBank setBNK_CODE (String BNK_CODE) {
        this.BNK_CODE = BNK_CODE;
        return this;
    }
}