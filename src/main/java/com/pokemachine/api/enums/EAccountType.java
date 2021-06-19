package com.pokemachine.api.enums;

/**
 * Account Type Enum
 * @author gbrextreme
 */
public enum EAccountType {
    /**
     * Saving account
     */
    Saving("P"),

    /**
     * Current Account
     */
    Current("C");

    /**
     * Enum type description  
     */
    private String description;

    /**
     * Constructor
     * @param description
     */
    private EAccountType (String description) {
        this.description = description;
    }

    /**
     *  Get Description 
     * @return Description
     */
    public String getDescription() {
        return description;
    }

}