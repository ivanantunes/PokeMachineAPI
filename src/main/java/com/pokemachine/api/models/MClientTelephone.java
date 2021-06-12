package com.pokemachine.api.models;

/**
 * Customer Telephone Model
 * @author ivanantunes
 */
public class MClientTelephone {
    
    /**
     * Client Telephone ID
     */
    private int CLT_ID;

    /**
     * Client ID
     */
    private int CLT_CLI_ID;

    /**
     * Client Telephone
     */
    private String CLT_TELEPHONE;

    /**
     * Constructor
     */
    private MClientTelephone() { }

    /**
     * Build Class
     * @return New Instance of MClientTelephone
     */ 
    public static MClientTelephone build() {
        return new MClientTelephone();
    }

    /**
     * Get CLT_ID
     * @return CLT_ID of Client Telephone
     */
    public int getCLT_ID() {
        return CLT_ID;
    }

    /**
     * Set CLT_ID
     * @param CLT_ID - ID of Client Telephone
     * @return Instance of Class
     */
    public MClientTelephone setCLT_ID(int CLT_ID) {
        this.CLT_ID = CLT_ID;
        return this;
    }

    /**
     * Get CLT_CLI_ID
     * @return CLT_CLI_ID of Client Telephone
     */
    public int getCLT_CLI_ID() {
        return CLT_CLI_ID;
    }

    /**
     * Set CLT_CLI_ID
     * @param CLT_CLI_ID - ID Client of Client Telephone
     * @return Instance of Class
     */
    public MClientTelephone setCLT_CLI_ID(int CLT_CLI_ID) {
        this.CLT_CLI_ID = CLT_CLI_ID;
        return this;
    }

    /**
     * Get CLT_TELEPHONE
     * @return CLT_TELEPHONE of Client Telephone
     */
    public String getCLT_TELEPHONE() {
        return CLT_TELEPHONE;
    }

    /**
     * Set CLT_TELEPHONE
     * @param CLT_TELEPHONE - Telephone of Client Telephone
     * @return Instance of Class
     */
    public MClientTelephone setCLT_TELEPHONE(String CLT_TELEPHONE) {
        this.CLT_TELEPHONE = CLT_TELEPHONE;
        return this;
    }
}
