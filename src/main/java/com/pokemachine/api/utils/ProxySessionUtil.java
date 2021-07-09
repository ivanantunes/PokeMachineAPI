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
    private static ProxySessionUtil instance = null;

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

            boolean cacheSession = CSession.getInstance().newSession(session);

            if (cacheSession) {

                MCashMachine machine = MCashMachine.Build()
                .setCSM_ID(lMachine.get(0).getCSM_ID())
                .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                .setCSM_STATUS("EU"); 
                
                crud.update(machine);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean authSession(MSession session) {
        MSession mSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (mSession != null) {
            List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

            if (lMachine.size() >= 1) {

                Boolean authSession = CSession.getInstance().authSession(session);
            
                if (!authSession) {

                    MCashMachine machine = MCashMachine.Build()
                        .setCSM_ID(lMachine.get(0).getCSM_ID())
                        .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                        .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                        .setCSM_STATUS("AT");

                    crud.update(machine);
                }
            }
        }

        return false;
    }

    @Override
    public boolean endSession(MSession session) {
        MSession mSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (mSession != null) {
            List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

            if (lMachine.size() >= 1) {
                
                boolean cacheSession = CSession.getInstance().endSession(session);
            
                if (cacheSession) {
                    MCashMachine machine = MCashMachine.Build()
                            .setCSM_ID(lMachine.get(0).getCSM_ID())
                            .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                            .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                            .setCSM_STATUS("AT");
                            
                    crud.update(machine);
                }
            }
        }
        return false;
    }

}
