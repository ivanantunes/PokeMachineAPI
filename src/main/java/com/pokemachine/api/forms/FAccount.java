package com.pokemachine.api.forms;

import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MClient;

/**
 * Account Form
 * 
 * @author LucasZaia
 */
public class FAccount {

    /**
     * Constructor
     */
    private FAccount() {
    }

    public static FAccount Build() {
        return new FAccount();
    }

    /**
     * Client Model
     */
    private MClient client;

    /**
     * Account Model
     */
    private MAccount account;

    /**
     * GET Client
     * 
     * @return MCLIENT Model
     */
    public MClient getClient() {
        return client;
    }

    /**
     * SET Client
     * 
     * @param MClient - Client of Form
     * @return Instance of Class
     */
    public FAccount setClient(MClient client) {
        this.client = client;
        return this;
    }

    /**
     * GET Account
     * 
     * @return MAccount Model
     */
    public MAccount getAccount() {
        return account;
    }

    /**
     * SET Account
     * 
     * @param MAccount - Account of Form
     * @return Instance of Class
     */
    public FAccount setAccount(MAccount account) {
        this.account = account;
        return this;
    }

}