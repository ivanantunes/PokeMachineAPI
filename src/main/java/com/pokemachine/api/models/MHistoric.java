package com.pokemachine.api.models;

import java.sql.Date;

/**
 * Customer Historic Model
 * 
 * @author LucasZaia
 */
public class MHistoric {

    /**
     * Historic ID
     */
    private int HIS_ID = 0;

    /**
     * Historic Cash Machine ID
     */
    private int HIS_CSM_ID = 0;

    /**
     * Historic Account ID
     */
    private int HIS_ACC_ID = 0;

    /**
     * Historic Operation
     */
    private String HIS_OPERATION;

    /**
     * Historic Datetime
     */
    private Date HIS_DATETIME;

    /**
     * Historic Value
     */
    private float HIS_VALUE = 0;

    /**
     * Constructor
     */
    private MHistoric() {
    }

    /**
     * Build Class
     * 
     * @return Instance of Class
     */
    public static MHistoric build() {
        return new MHistoric();
    }

    /**
     * Get HIS_ID
     * 
     * @return HIS_ID of Historic
     */
    public int getHIS_ID() {
        return HIS_ID;
    }

    /**
     * Set HIS_ID
     * 
     * @param HIS_ID - ID of Historic
     * @return istance of Class
     */
    public MHistoric setHIS_ID(int HIS_ID) {
        this.HIS_ID = HIS_ID;
        return this;
    }

    /**
     * Get HIS_CSM_ID
     * 
     * @return HIS_CSM_ID of Historic
     */
    public int getHIS_CSM_ID() {
        return HIS_CSM_ID;
    }

    /**
     * Set HIS_CSM_ID
     * 
     * @param HIS_CSM_ID - ID of Cash Machine
     * @return instance of Class
     */
    public MHistoric setHIS_CSM_ID(int HIS_CSM_ID) {
        this.HIS_CSM_ID = HIS_CSM_ID;
        return this;
    }

    /**
     * Get HIS_ACC_ID
     * 
     * @return HIS_ACC_ID of Historic
     */
    public int getHIS_ACC_ID() {
        return HIS_ACC_ID;
    }

    /**
     * Set HIS_ACC_ID
     * 
     * @param HIS_ACC_ID - ID of Account
     * @return instance of Class
     */
    public MHistoric setHIS_ACC_ID(int HIS_ACC_ID) {
        this.HIS_ACC_ID = HIS_ACC_ID;
        return this;
    }

    /**
     * Get HIS_OPERATION
     * 
     * @return HIS_OPERATION of Historic
     */
    public String getHIS_OPERATION() {
        return HIS_OPERATION;
    }

    /**
     * Set HIS_OPERATION
     * 
     * @param HIS_OPERATION - Historic Operation
     * @return instance of Class
     */
    public MHistoric setHIS_OPERATION(String HIS_OPERATION) {
        this.HIS_OPERATION = HIS_OPERATION;
        return this;
    }

    /**
     * Get HIS_DATETIME
     * 
     * @return HIS_DATETIME of Historic
     */
    public Date getHIS_DATETIME() {
        return HIS_DATETIME;
    }

    /**
     * Set HIS_DATETIME
     * 
     * @param HIS_DATETIME - Date time of Historic
     * @return instance of CLass
     */
    public MHistoric setHIS_DATETIME(Date HIS_DATETIME) {
        this.HIS_DATETIME = HIS_DATETIME;
        return this;
    }

    /**
     * Get HIS_VALUE
     * 
     * @return HIS_VALUE of Historic
     */
    public float getHIS_VALUE() {
        return HIS_VALUE;
    }

    /**
     * Set HIS_VALUE
     * 
     * @param HIS_VALUE - Value of Historic
     * @return Instance of Class
     */
    public MHistoric setHIS_VALUE(float HIS_VALUE) {
        this.HIS_VALUE = HIS_VALUE;
        return this;
    }

}