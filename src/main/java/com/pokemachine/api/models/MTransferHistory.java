package com.pokemachine.api.models;

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
     * Tranfer Origin Account ID
     */
    private int TRH_ORIGIN_ACC_ID = 0;

    /**
     * Transfer Destiny Account ID
     */
    private int TRH_DESTINY_ACC_ID = 0;

    /**
     * Transfer History Value
     */
    private float TRH_VALUE = 0;

    /**
     * Transfer History Date Time
     */
    private String TRH_DATETIME;

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
    public MTransferHistory setTRH_DATETIME (String TRH_DATETIME) {
        this.TRH_DATETIME = TRH_DATETIME;
        return this;
    }

    /**
     * Get TRH_DATETIME
     * @return TRH_DATETIME of Transfer History
     */
    public String getTRH_DATETIME () {
        return TRH_DATETIME;
    }

    /**
     * Get TRH_ORIGIN_ACC_ID
     * @return TRH_ORIGIN_ACC_ID of Transfer History
     */
    public int getTRH_ORIGIN_ACC_ID() {
        return TRH_ORIGIN_ACC_ID;
    }

    /**
     * Set TRH_ORIGIN_ACC_ID
     * @param TRH_ORIGIN_ACC_ID - ID Origin Account of Transfer History
     * @return Instance of Class
     */
    public MTransferHistory setTRH_ORIGIN_ACC_ID(int TRH_ORIGIN_ACC_ID) {
        this.TRH_ORIGIN_ACC_ID = TRH_ORIGIN_ACC_ID;
        return this;
    }

    /**
     * Get TRH_DESTINY_ACC_ID
     * @return TRH_DESTINY_ACC_ID of Transfer History
     */
    public int getTRH_DESTINY_ACC_ID() {
        return TRH_DESTINY_ACC_ID;
    }

    /**
     * Set TRH_DESTINY_ACC_ID
     * @param TRH_DESTINY_ACC_ID - ID Destiny Account of Transfer History
     * @return Instance of Class
     */
    public MTransferHistory setTRH_DESTINY_ACC_ID(int TRH_DESTINY_ACC_ID) {
        this.TRH_DESTINY_ACC_ID = TRH_DESTINY_ACC_ID;
        return this;
    }
    
}