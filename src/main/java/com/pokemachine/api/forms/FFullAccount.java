package com.pokemachine.api.forms;

import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MClient;
import com.pokemachine.api.models.MClientAddress;
import com.pokemachine.api.models.MClientTelephone;

/**
 * Full Account Form
 * @author gbrextreme
 */
public class FFullAccount {
    

    /**
     * Constructor
     */
    private FFullAccount () { }

    public static FFullAccount Build() {
        return new FFullAccount();
    }

    /**
     * Client Model
     */
    private MClient client;

    /**
     * Client Telephone Model
     */
    private MClientTelephone clientTelephone;

    /**
     * Client Address Model
     */
    private MClientAddress clientAddress;

    /**
     * Account Model
     */
    private MAccount account;


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
    public FFullAccount setClient(MClient client) {
        this.client = client;
        return this;
    }

    /**
     * GET Client Telephone 
     * @return MClientTelephone Model
     */
    public MClientTelephone getClientTelephone() {
        return clientTelephone;
    }

    /**
     * SET Client Telephone
     * @param MClientTelephone - Client Telephone of Form
     * @return Instance of Class
     */
    public FFullAccount setClientTelephone(MClientTelephone clientTelephone) {
        this.clientTelephone = clientTelephone;
        return this;
    }

    /**
     * GET Client Address 
     * @return MClientAddress Model
     */
    public MClientAddress getClientAddress() {
        return clientAddress;
    }

    /**
     * SET Client Address
     * @param MClientAddress - Client Address of Form
     * @return Instance of Class
     */
    public FFullAccount setClientAddress(MClientAddress clientAddress) {
        this.clientAddress = clientAddress;
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
    public FFullAccount setAccount(MAccount account) {
        this.account = account;
        return this;
    }

}
