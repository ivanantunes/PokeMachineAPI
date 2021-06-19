package com.pokemachine.api.models;

/**
 * Card Model
 * @author gbrextreme 
 */
public class MTransferHistory {

    /**
     * Transfer History ID
     */
    private int TRH_ID;

    /**
     * Transfer History Value
     */
    private Float TRH_VALUE;

    /**
     * Transfer History Date Time
     */
    private DateTime TRH_DATETIME;

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
     * Get TRH_ID
     * @return TRH_ID of Transfer History
     */
    public int getTRH_ID () {
        return TRH_ID;
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
     * Get TRH_DATETIME
     * @return TRH_DATETIME of Transfer History
     */
    public int getTRH_DATETIME () {
        return TRH_DATETIME;
    }

    /**
     * Set TRH_DATETIME
     * @param TRH_DATETIME - Date Time of Transfer History
     * @return instance of Class
     */
    public MTransferHistory setTRH_DATETIME (DateTime TRH_DATETIME) {
        this.TRH_DATETIME = TRH_DATETIME;
        return this;
    }

}