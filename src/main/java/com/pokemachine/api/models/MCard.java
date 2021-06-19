package com.pokemachine.api.models;

import com.pokemachine.api.enums.ECardType;

/**
 * Card Model
 * @author gbrextreme 
 */
public class MCard {
    
    /**
     * Card ID 
     */
    private int CAR_ID;

    /**
     * Card Code
     */
    private int CAR_CODE;

    /**
     * Card Expiration Date
     */
    private Date CAR_EXPIRATION_DATE;

    /**
     * Card Type
     */
    private ECardType CAR_TYPE;

    /**
     * Card CVV
     */
    private Int CAR_CVV;

    /**
     * Card Status
     */
    private Boolean CAR_STATUS;

    /**
     * Card Password
     */
    private String CAR_PASSWORD;

    /**
     * Constructor
     */
    private MCard() { };

    /**
     * Build Class
     * @return instance of Class
     */
    public static MCard Build() {
        return new MCard();
    }
    
    /**
     * Get CAR_ID
     * @return CAR_ID of Card
     */
    public int getCAR_ID () {
        return CAR_ID;
    }

    /**
     * Set CAR_ID
     * @param CAR_ID - ID of Card
     * @return instance of Class
     */
    public MCard setCAR_ID (int CAR_ID) {
        this.CAR_ID = CAR_ID;
        return this;
    }

    /**
     * Get CAR_CODE
     * @return CAR_CODE of Card
     */
    public int getCAR_CODE () {
        return CAR_CODE;
    }

    /**
     * Set CAR_CODE
     * @param CAR_CODE - Code of Card
     * @return instance of Class
     */
    public MCard setCAR_CODE (int CAR_COTE) {
        this.CAR_COTE = CAR_COTE;
        return this;
    }

    /**
     * Get CAR_EXPIRATION_DATE
     * @return CAR_EXPIRATION_DATE of Card
     */
    public int getCAR_EXPIRATION_DATE () {
        return CAR_EXPIRATION_DATE;
    }

    /**
     * Set CAR_EXPIRATION_DATE
     * @param CAR_EXPIRATION_DATE - Expirantion Date of Card
     * @return instance of Class
     */
    public MCard setCAR_EXPIRATION_DATE (Date CAR_EXPIRATION_DATE) {
        this.CAR_EXPIRATION_DATE = CAR_EXPIRATION_DATE;
        return this;
    }

    /**
     * Get CAR_TYPE
     * @return CAR_TYPE of Card
     */
    public int getCAR_TYPE () {
        return CAR_TYPE;
    }

    /**
     * Set CAR_TYPE
     * @param CAR_TYPE - Type of Card
     * @return instance of Class
     */
    public MCard setCAR_TYPE (ECardType CAR_TYPE) {
        this.CAR_TYPE = CAR_TYPE;
        return this;
    }

    /**
     * Get CAR_CVV
     * @return CAR_CVV of Card
     */
    public int getCAR_CVV () {
        return CAR_CVV;
    }

    /**
     * Set CAR_CVV
     * @param CAR_CVV - CVV of Card
     * @return instance of Class
     */
    public MCard setCAR_CVV (Int CAR_CVV) {
        this.CAR_CVV = CAR_CVV;
        return this;
    }

    /**
     * Get CAR_STATUS
     * @return CAR_STATUS of Card
     */
    public int getCAR_STATUS () {
        return CAR_STATUS;
    }

    /**
     * Set CAR_STATUS
     * @param CAR_STATUS - Status of Card
     * @return instance of Class
     */
    public MCard setCAR_STATUS (Boolean CAR_STATUS) {
        this.CAR_STATUS = CAR_STATUS;
        return this;
    }

    /**
     * Get CAR_PASSWORD
     * @return CAR_PASSWORD of Card
     */
    public int getCAR_PASSWORD () {
        return CAR_PASSWORD;
    }

    /**
     * Set CAR_PASSWORD
     * @param CAR_PASSWORD - Password of Card
     * @return instance of Class
     */
    public MCard setCAR_PASSWORD (String CAR_PASSWORD) {
        this.CAR_PASSWORD = CAR_PASSWORD;
        return this;
    }
}