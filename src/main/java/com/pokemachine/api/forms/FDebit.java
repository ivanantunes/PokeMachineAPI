package com.pokemachine.api.forms;

/**
 * Debit Form
 * @author gbrextreme
 * @author LucasZaia
 */
public class FDebit {

    /**
    * FLogin Value
    */
    private float ACC_VALUE;

    /**
     * Construct
     */
    private FDebit(){}

    /**
     * Build Class
     * @return new instance for Class FDebit
     */
    public static FDebit Build () {
        return new FDebit();    
    }

    /**
     * GET ACC_VALUE 
     * @return Account value
     */
    public float getACC_VALU () {
        return ACC_VALUE;
    }

    /**
     * SET ACC_VALUE
     * @param ACC_VALUE - Value of Form
     * @return Instance of Class
     */
    public FDebit setACC_VALUE (float ACC_VALUE) {
        this.ACC_VALUE = ACC_VALUE;
        return this;
    }
        
}
