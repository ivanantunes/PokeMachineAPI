package com.pokemachine.api.models;

/**
 * Customer Model
 * @author ivanantunes
 */
public class MClient {
    
    /**
     * Client ID
     */
    private int CLI_ID = 0;

    /**
     * Client Full Name
     */
    private String CLI_FULL_NAME = "";

    /**
     * Client Rg
     */
    private String CLI_RG = "";

    /**
     * Client Cpf
     */
    private String CLI_CPF = "";

    /**
     * Client BIRTHDAY
     */
    private String CLI_BIRTHDAY = "";

    /**
     * Constructor
     */
    private MClient() { }

    /**
     * Build Class
     * @return New Instance of MClient
     */    
    public static MClient build() {
        return new MClient();
    }

    /**
     * Get CLI_ID
     * @return CLI_ID of Client
     */
    public int getCLI_ID() {
        return CLI_ID;
    }

    /**
     * Set CLI_ID
     * @param CLI_ID - ID of Client
     * @return Instance of Class
     */
    public MClient setCLI_ID(int CLI_ID) {
        this.CLI_ID = CLI_ID;
        return this;
    }

    /**
     * Get CLI_FULL_NAME
     * @return CLI_FULL_NAME of Client
     */
    public String getCLI_FULL_NAME() {
        return CLI_FULL_NAME;
    }

    /**
     * Set CLI_FULL_NAME
     * @param CLI_FULL_NAME - Full Name of Client
     * @return Instance of Class
     */
    public MClient setCLI_FULL_NAME(String CLI_FULL_NAME) {
        this.CLI_FULL_NAME = CLI_FULL_NAME;
        return this;
    }

    /**
     * Get CLI_RG
     * @return CLI_RG of Client
     */
    public String getCLI_RG() {
        return CLI_RG;
    }

    /**
     * Set CLI_RG
     * @param CLI_RG - Rg of Client
     * @return Instance of Class
     */
    public MClient setCLI_RG(String CLI_RG) {
        this.CLI_RG = CLI_RG;
        return this;
    }

    /**
     * Get CLI_CPF
     * @return CLI_CPF of Client
     */
    public String getCLI_CPF() {
        return CLI_CPF;
    }

    /**
     * Set CLI_CPF
     * @param CLI_CPF - CPF of Client
     * @return Instance of Class
     */
    public MClient setCLI_CPF(String CLI_CPF) {
        this.CLI_CPF = CLI_CPF;
        return this;
    }

    /**
     * Get CLI_BIRTHDAY
     * @return CLI_BIRTHDAY of Client
     */
    public String getCLI_BIRTHDAY() {
        return CLI_BIRTHDAY;
    }

    /**
     * Set CLI_BIRTHDAY
     * @param CLI_BIRTHDAY - BIRTHDAY of Client
     * @return Instance of Class
     */
    public MClient setCLI_BIRTHDAY(String CLI_BIRTHDAY) {
        this.CLI_BIRTHDAY = CLI_BIRTHDAY;
        return this;
    }
}
