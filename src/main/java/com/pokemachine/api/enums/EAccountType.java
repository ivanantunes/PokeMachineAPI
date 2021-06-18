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
     *  Get Description 
     * @return Description
     */
    public String getDescription() {
        return description;
    }

}