package com.pokemachine.api.enums;

/**
 * Card Type Enum
 * @author gbrextreme
 */
public enum ECardType {
    
    /**
     * Debit Card
     */
    Debit("D"),
    /**
     * Credit Card
     */
    Credit("C"),
    /**
     * Debit and Credit Card
     */
    DebitCredit("DC");

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