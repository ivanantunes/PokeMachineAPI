package com.pokemachine.api.models;

/**
 * Customer Model
 * autor LucasZaia
 */

public class MAgency{

    /**
     * Agency ID
     */
    private int AGE_ID = 0;

    /**
     * Agency Bank ID
     */
    private int AGE_BNK_ID = 0;

    /**
     * Agency Name
     */
    private String AGE_NAME = "";

    /**
     * Agency Agency Code
     */
    private String AGE_CODE = "";

    /**
     * Constructor
     */
    private MAgency(){}

    /**
     * Build Class
     * @return New Instance of MAgency
     */
    public static MAgency build(){
        return MAgency();
    }

    /**
     * Get AGE_ID  
     * @return AGE_ID of Agency
     */
    public int getAGE_ID(){
        return AGE_ID;
    }

    /**
     * Set AGE_ID
     * @param AGE_ID - ID of Agency
     * @return instance of Class
     */
    public MAgency setAGE_ID(int AGE_ID){
        this.AGE_ID = AGE_ID;
        return this;
    }

    /**
     * Get AGE_BNK_ID
     * @return AGE_BNK_ID of Agency
     */
    public int getAGE_BNK_ID(){
        return AGE_BNK_ID;
    }

    /**
     * Set AGE_BNK_ID
     * @param AGE_BNK_ID - ID Bank of Agency
     * @return instance of Class
     */
    public MAgency setAGE_BNK_ID(int AGE_BNK_ID){
        this.AGE_BNK_ID = AGE_BNK_ID;
        return this;
    }

    /**
     * Get AGE_NAME
     * @return AGE_NAME of Agency
     */
    public String getAGE_NAME(){
        return AGE_NAME;
    }

    /**
     * Set AGE_NAME
     * @param AGE_NAME - Name of Agency 
     * @return instance of Class
     */
    public MAgency setAGE_NAME(String AGE_NAME){
        this.AGE_NAME = AGE_NAME;
        return this;
    }

    /**
     * Get AGE_CODE
     * @return AGE_CODE of Agency
     */
    public String getAGE_CODE(){
        return AGE_CODE;
    }

    /**
     * Set AGE_CODE
     * @param AGE_CODE - CODE of Agency
     * @return instance of Class
     */
    public MAgency setAGE_CODE(String AGE_CODE){
        this.AGE_CODE = AGE_CODE;
        return this;
    }
}