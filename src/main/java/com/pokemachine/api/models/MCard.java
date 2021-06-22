package com.pokemachine.api.models;

/**
 * Card Model
 * @author gbrextreme 
 */
public class MCard {
    
    /**
     * Card ID 
     */
    private int CAR_ID = 0;

    /**
     * Card Account ID
     */
    private int CAR_ACC_ID = 0;

    /**
     * Card Code
     */
    private String CAR_CODE = "";

    /**
     * Card Expiration Date
     */
    private String CAR_EXPIRATION_DATE = "";

    /**
     * Card Type
     */
    private String CAR_TYPE = "";

    /**
     * Card CVV
     */
    private int CAR_CVV = 0;

    /**
     * Card Status
     */
    private boolean CAR_STATUS = false;

    /**
     * Card Password
     */
    private String CAR_PASSWORD = "";

    /**
     * Card Limit
     */
    private float CAR_LIMIT = 0;

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
     * Get CAR_ACC_ID
     * @return CAR_ACC_ID of Card
     */
    public int getCAR_ACC_ID () {
        return CAR_ACC_ID;
    }

    /**
     * Set CAR_ACC_ID
     * @param CAR_ACC_ID - Account id of Card
     * @return instance of Class
     */
    public MCard setCAR_ACC_ID (int CAR_ACC_ID) {
        this.CAR_ACC_ID = CAR_ACC_ID;
        return this;
    }

    /**
     * Get CAR_CODE
     * @return CAR_CODE of Card
     */
    public String getCAR_CODE () {
        return CAR_CODE;
    }

    /**
     * Set CAR_CODE
     * @param CAR_CODE - Code of Card
     * @return instance of Class
     */
    public MCard setCAR_CODE (String CAR_CODE) {
        this.CAR_CODE = CAR_CODE;
        return this;
    }

    /**
     * Get CAR_EXPIRATION_DATE
     * @return CAR_EXPIRATION_DATE of Card
     */
    public String getCAR_EXPIRATION_DATE () {
        return CAR_EXPIRATION_DATE;
    }

    /**
     * Set CAR_EXPIRATION_DATE
     * @param CAR_EXPIRATION_DATE - Expirantion Date of Card
     * @return instance of Class
     */
    public MCard setCAR_EXPIRATION_DATE (String CAR_EXPIRATION_DATE) {
        this.CAR_EXPIRATION_DATE = CAR_EXPIRATION_DATE;
        return this;
    }

    /**
     * Get CAR_TYPE
     * @return CAR_TYPE of Card
     */
    public String getCAR_TYPE () {
        return CAR_TYPE;
    }

    /**
     * Set CAR_TYPE
     * @param CAR_TYPE - Type of Card
     * @return instance of Class
     */
    public MCard setCAR_TYPE (String CAR_TYPE) {
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
    public MCard setCAR_CVV (int CAR_CVV) {
        this.CAR_CVV = CAR_CVV;
        return this;
    }

    /**
     * Get CAR_STATUS
     * @return CAR_STATUS of Card
     */
    public boolean getCAR_STATUS () {
        return CAR_STATUS;
    }

    /**
     * Set CAR_STATUS
     * @param CAR_STATUS - Status of Card
     * @return instance of Class
     */
    public MCard setCAR_STATUS (boolean CAR_STATUS) {
        this.CAR_STATUS = CAR_STATUS;
        return this;
    }

    /**
     * Get CAR_PASSWORD
     * @return CAR_PASSWORD of Card
     */
    public String getCAR_PASSWORD () {
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

    /**
     * Get CAR_LIMIT
     * @return CAR_LIMIT of Card
     */
    public float getCAR_LIMIT() {
        return CAR_LIMIT;
    }   

    /**
     * Set CAR_LIMIT
     * @param CAR_LIMIT - Limit of Card
     * @return instance of Class
     */
    public MCard setCAR_LIMIT (float CAR_LIMIT) {
        this.CAR_LIMIT = CAR_LIMIT;
        return this;
    }

}