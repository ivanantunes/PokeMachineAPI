package com.pokemachine.api.models;

/**
 * Customer Address Model
 * @author ivanantunes
 */
public class MClientAddress {
    
    /**
     * Client Address ID
     */
    private int CLA_ID = 0;

    /**
     * Client ID
     */
    private int CLA_CLI_ID = 0;

    /**
     * Client Address Zip Code
     */
    private String CLA_ZIP_CODE = "";

    /**
     * Client Address
     */
    private String CLA_ADDRESS = "";

    /**
     * Client Address Districty
     */
    private String CLA_DISTRICTY = "";

    /**
     * Client Address City
     */
    private String CLA_CITY = "";

    /**
     * Client Address UF
     */
    private String CLA_UF = "";

    /**
     * Constructor
     */
    private MClientAddress() { }

    /**
     * Build Class
     * @return Instance of Class
     */
    public static MClientAddress build() {
        return new MClientAddress();
    }

    /**
     * Get CLA_ID
     * @return ID
     */
    public int getCLA_ID() {
        return CLA_ID;
    }

    /**
     * Set CLA_ID
     * @param CLA_ID - ID of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_ID(int CLA_ID) {
        this.CLA_ID = CLA_ID;
        return this;
    }

    /**
     * Get CLA_UF
     * @return UF
     */
    public String getCLA_UF() {
        return CLA_UF;
    }

    /**
     * Set CLA_UF
     * @param CLA_UF - UF of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_UF(String CLA_UF) {
        this.CLA_UF = CLA_UF;
        return this;
    }

    /**
     * Get CLA_CITY
     * @return CITY
     */
    public String getCLA_CITY() {
        return CLA_CITY;
    }

    /**
     * Set CLA_CITY
     * @param CLA_CITY - CITY of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_CITY(String CLA_CITY) {
        this.CLA_CITY = CLA_CITY;
        return this;
    }

    /**
     * Get CLA_DISTRICTY
     * @return DISTRICTY
     */
    public String getCLA_DISTRICTY() {
        return CLA_DISTRICTY;
    }

    /**
     * Set CLA_DISTRICTY
     * @param CLA_DISTRICTY - DISTRICTY of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_DISTRICTY(String CLA_DISTRICTY) {
        this.CLA_DISTRICTY = CLA_DISTRICTY;
        return this;
    }

    /**
     * Get CLA_ADDRESS
     * @return Address
     */
    public String getCLA_ADDRESS() {
        return CLA_ADDRESS;
    }

    /**
     * Set CLA_ADDRESS
     * @param CLA_ADDRESS - ADDRESS of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_ADDRESS(String CLA_ADDRESS) {
        this.CLA_ADDRESS = CLA_ADDRESS;
        return this;
    }

    /**
     * Get CLA_ZIP_CODE
     * @return Zip Code
     */
    public String getCLA_ZIP_CODE() {
        return CLA_ZIP_CODE;
    }

    /**
     * Set CLA_ZIP_CODE
     * @param CLA_ZIP_CODE - ZIP CODE of Client Address
     * @return Instance of Class
     */
    public MClientAddress setCLA_ZIP_CODE(String CLA_ZIP_CODE) {
        this.CLA_ZIP_CODE = CLA_ZIP_CODE;
        return this;
    }

    /**
     * Get CLA_CLI_ID
     * @return Client ID
     */
    public int getCLA_CLI_ID() {
        return CLA_CLI_ID;
    }

    /**
     * Set CLA_CLI_ID
     * @param CLA_CLI_ID - Client ID
     * @return Instance of Class
     */
    public MClientAddress setCLA_CLI_ID(int CLA_CLI_ID) {
        this.CLA_CLI_ID = CLA_CLI_ID;
        return this;
    }

}
