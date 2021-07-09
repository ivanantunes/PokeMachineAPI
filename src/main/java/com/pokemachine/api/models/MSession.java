package com.pokemachine.api.models;

import java.time.LocalDateTime;

public class MSession {
    
    /**
     * Session Cash Machine ID
     */
    private int SSI_CSM_ID = 0;

    /**
     * Session Account Code
     */
    private String SSI_ACC_CODE = "";
    
    /**
     * Session Token
     */
    private String SSI_TOKEN = "";

    /**
     * Session Date
     */
    private LocalDateTime SSI_DATE = null;

    /**
     * Constructor
     */
    private MSession() { }

    /**
     * Build Class
     * @return Instance of Class
     */
    public static MSession Build() {
        return new MSession();
    }

    /**
     * GET SSI_CSM_ID; 
     * @return SSI_CSM_ID of Session Class
     */
    public int getSSI_CSM_ID() {
        return SSI_CSM_ID;
    }

    /**
     * SET SSI_CSM_ID
     * @param SSI_CSM_ID - Cash Machine ID of Session
     * @return Instance of Class
     */
    public MSession setSSI_CSM_ID(int SSI_CSM_ID) {
        this.SSI_CSM_ID = SSI_CSM_ID;
        return this;
    }

    /**
     * GET SSI_ACC_CODE
     * @return SSI_ACC_CODE of Session Class
     */
    public String getSSI_ACC_CODE() {
        return SSI_ACC_CODE;
    }

    /**
     * SET SSI_ACC_CODE
     * @param SSI_ACC_CODE - Account Code of Session
     * @return Instance of Class
     */    
    public MSession setSSI_ACC_CODE(String SSI_ACC_CODE) {
        this.SSI_ACC_CODE = SSI_ACC_CODE;
        return this;
    }

    /**
     * GET SSI_TOKEN
     * @return SSI_TOKEN of Session Class
     */
    public String getSSI_TOKEN() {
        return SSI_TOKEN;
    }

    /**
     * SET SSI_TOKEN
     * @param SSI_TOKEN - Token of Session Class
     * @return Instance of Class
     */
    public MSession setSSI_TOKEN(String SSI_TOKEN) {
        this.SSI_TOKEN = SSI_TOKEN;
        return this;
    }

    /**
     * GET SSI_DATE
     * @return SSI_DATE of Session Class
     */
    public LocalDateTime getSSI_DATE() {
        return SSI_DATE;
    }

    /**
     * SET SSI_SESSION
     * @param SSI_DATE - Date of Session Class
     * @return Instance of Class
     */
    public MSession setSSI_DATE(LocalDateTime SSI_DATE) {
        this.SSI_DATE = SSI_DATE;
        return this;
    }

}
