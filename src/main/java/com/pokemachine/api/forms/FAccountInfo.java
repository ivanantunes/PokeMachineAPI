package com.pokemachine.api.forms;

import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MAgency;
import com.pokemachine.api.models.MClient;

/**
 * Account Info
 * @author ivanantunes
 */
public class FAccountInfo {
    /**
     * Client Model
     */
    private MClient client;

    /**
     * Account Model
     */
    private MAccount account;

    /**
     * Agency Model
     */
    private MAgency agency;

    /**
     * Constructor
     */
    private FAccountInfo() { }

    /**
     * Build Class
     * @return New instance fo Class FAccountInfo
     */
    public static FAccountInfo build() {
        return new FAccountInfo();
    }

    /**
     * GET Client 
     * @return MCLIENT Model
     */
    public MClient getClient() {
        return client;
    }

    /**
     * SET Client
     * @param MClient - Client of Form
     * @return Instance of Class
     */
    public FAccountInfo setClient(MClient client) {
        this.client = client;
        return this;
    }

    /**
     * GET Account 
     * @return MAccount Model
     */
    public MAccount getAccount() {
        return account;
    }

    /**
     * SET Account
     * @param MAccount - Account of Form
     * @return Instance of Class
     */
    public FAccountInfo setAccount(MAccount account) {
        this.account = account;
        return this;
    }

    /**
     * GET Agency 
     * @return MAccount Model
     */
    public MAgency getAgency() {
        return agency;
    }

    /**
     * SET Agency
     * @param MAgency - Agency of Form
     * @return Instance of Class
     */
    public FAccountInfo setAgency(MAgency agency) {
        this.agency = agency;
        return this;
    }
}
