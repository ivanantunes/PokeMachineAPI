package com.pokemachine.api.models;

import java.util.Date;

/**
 * Card Model
 * @author gbrextreme 
 */
public class MTransferHistory {

    /**
     * Transfer History ID
     */
    private int TRH_ID = 0;

    /**
     * Transfer History Value
     */
    private float TRH_VALUE = 0;

    /**
     * Transfer History Date Time
     */
    private Date TRH_DATETIME;

    /**
     * Constructor
     */
    private MTransferHistory() { };

    /**
     * Build Class
     * @return instance of Class
     */
    public static MTransferHistory Build() {
        return new MTransferHistory();
    }

    /**
     * Set TRH_ID
     * @param TRH_ID - ID of Transfer History
     * @return instance of Class
     */
    public MTransferHistory setTRH_ID (int TRH_ID) {
        this.TRH_ID = TRH_ID;
        return this;
    }

    /**
     * Get TRH_ID
     * @return TRH_ID of Transfer History
     */
    public int getTRH_ID () {
        return TRH_ID;
    }

    /**
     * Set TRH_VALUE
     * @param TRH_VALUE - Value of Transfer History
     * @return Instance of Class
     */
    public MTransferHistory setTRH_VALUE (float TRH_VALUE) {
        this.TRH_VALUE = TRH_VALUE;
        return this;
    }

    /**
     * Get TRH_VALUE
     * @return THR_VALUE of Transfer History
     */
    public float getTRH_VALUE () {
        return TRH_VALUE;
    }


    /**
     * Set TRH_DATETIME
     * @param TRH_DATETIME - Date Time of Transfer History
     * @return instance of Class
     */
    public MTransferHistory setTRH_DATETIME (Date TRH_DATETIME) {
        this.TRH_DATETIME = TRH_DATETIME;
        return this;
    }

    /**
     * Get TRH_DATETIME
     * @return TRH_DATETIME of Transfer History
     */
    public Date getTRH_DATETIME () {
        return TRH_DATETIME;
    }

}