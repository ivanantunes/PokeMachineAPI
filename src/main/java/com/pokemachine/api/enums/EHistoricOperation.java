package com.pokemachine.api.enums;

/**
 * Historic Operation Enum
 * @author LucasZaia
 */
public enum EHistoricOperation {
    /**
     * Withdraw Historic
     */
    Withdraw("S"),

    /**
     * Deposit Historic
     */
    Deposit("D"),

    /**
     * Transfer Historic
     */
    Transfer("T");

    /**
     * Enum type description 
     */
    private String description;

    /**
     * Get description
    */
    public String getDescription () {
        return description;
    }
}