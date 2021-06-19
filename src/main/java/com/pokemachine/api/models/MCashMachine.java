package com.pokemachine.api.models;

/**
 * Customer Cash Machine Model
 * @author LucasZaia
 */
public class MCashMachine {
    /**
     * Cash Machine ID
     */
    private int CSM_ID = 0;

    /**
     * Cash Machine Name 
     */
    private String CSM_NAME = "";

    /**
     * Cash Machine Available Value
     */
    private Float CSM_AVAILABLE_VALUE = 0;

    /**
     * Constructor
     */
    private MCashMachine () {}

    /**
     * Build Class
     * @return Instance of Class
     */
    public static MCashMachine build () {
        return MCashMachine();
    }

    /**
     * Get CSM_ID
     * @return CSM_ID of Cash Machine
     */
    public int getCSM_ID () {
        return CSM_ID;
    }

    /**
     * Set CSM_ID
     * @param CSM_ID - Cash Machine ID
     * @return Instance of Class
     */
    public MCashMachine setCSM_ID (int CSM_ID) {
        this.CSM_ID = CSM_ID;
        return this;
    }

    /**
     * Get CSM_NAME
     * @return CSM_NAME of Cash Machine
     */
    public String getCSM_NAME () {
        return CSM_NAME;
    }

    /**
     * Set CSM_NAME
     * @param CSM_NAME - Name of Cash Machine 
     * @return Instance of Class
     */
    public MCashMachine setCSM_NAME (String CSM_NAME) {
        this.CSM_NAME = CSM_NAME;
        return this;
    }

    /**
     * Get CSM_AVAILABLE_VALUE
     * @return CSM_AVAILABLE_VALUE of Cash Machine 
     */
    public Float getCSM_AVAILABLE_VALUE () {
        return CSM_AVAILABLE_VALUE;
    }

    /**
     * Set CSM_AVAILABLE_VALUE
     * @param CSM_AVAILABLE_VALUE - Available Value of Cash Machine
     * @return
     */
    public MCashMachine setCSM_AVAILABLE_VALUE (Float CSM_AVAILABLE_VALUE) {
        this.CSM_AVAILABLE_VALUE = CSM_AVAILABLE_VALUE;
        return this;
    }
}