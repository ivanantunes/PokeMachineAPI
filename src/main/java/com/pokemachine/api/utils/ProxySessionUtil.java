package com.pokemachine.api.utils;

import java.util.List;

import com.pokemachine.api.cache.CSession;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.models.MSession;

/**
 * Proxy Service Session Util
 */
public class ProxySessionUtil implements ProxyService {
    

    /**
     * Cash Machine Crud Instance
     */
    private CashMachineCrud crud = CashMachineCrud.getInstance();

    /**
     * Instance of Class
     */
    private static ProxySessionUtil instance;

    /**
     * Constructor
     */
    private ProxySessionUtil() { }

    /**
     * Get instance of Class
     * @return Instance of Class
     */
    public static ProxySessionUtil getInstance() {
        if (instance == null) {
            instance = new ProxySessionUtil();
        }
        return instance;
    }

    /**
     * Dentroy instance method
     */
    public void destroyInstance() {
        instance = null;
    }


    @Override
    public boolean newSession(MSession session) {

        List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

        if (lMachine.size() >= 1) {

            if (lMachine.get(0).getCSM_STATUS().contains("EU") || lMachine.get(0).getCSM_STATUS().contains("IN")) {
                return false;
            }


        }

        /**
         * criando diversas sessoes para cada coisa
         * trocar para token
         * verificar code se existe sessao
         */

        return false;
    }

    @Override
    public boolean authSession(MSession session) {
        List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

        if (lMachine.size() >= 1) {
            return CSession.getInstance().authSession(session);
        }

        return false;
    }

    @Override
    public boolean endSession(MSession session) {
        return CSession.getInstance().endSession(session);
    }

}
