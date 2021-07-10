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

        if (lMachine.size() == 1) {

            CSession cSession = CSession.getInstance();

            MSession isSession = cSession.getSessionByCode(session.getSSI_ACC_CODE());

            if (isSession != null) {

                MCashMachine currentMachine = MCashMachine.Build()
                .setCSM_ID(lMachine.get(0).getCSM_ID())
                .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                .setCSM_STATUS("EU");

                if (isSession.getSSI_CSM_ID() != session.getSSI_CSM_ID()) {
                    List<MCashMachine> lMachineOld = crud.getDataByID(isSession.getSSI_CSM_ID());

                    MCashMachine oldMachine = MCashMachine.Build()
                    .setCSM_ID(lMachineOld.get(0).getCSM_ID())
                    .setCSM_NAME(lMachineOld.get(0).getCSM_NAME())
                    .setCSM_AVAILABLE_VALUE(lMachineOld.get(0).getCSM_AVAILABLE_VALUE())
                    .setCSM_STATUS("AT");
    
                    cSession.removeSessionByToken(isSession.getSSI_TOKEN());
                    crud.update(oldMachine);
                }
                crud.update(currentMachine);

                return cSession.newSession(session);
            } else {
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

        }

        return false;
    }

    @Override
    public boolean authSession(MSession session) {
        MSession mSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (mSession != null) {
            List<MCashMachine> lMachine = crud.getDataByID(mSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {

                boolean authSession = CSession.getInstance().authSession(mSession);
            
                if (!authSession) {

                    MCashMachine machine = MCashMachine.Build()
                        .setCSM_ID(lMachine.get(0).getCSM_ID())
                        .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                        .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                        .setCSM_STATUS("AT");

                    crud.update(machine);

                    return false;
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean endSession(MSession session) {
        MSession mSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (mSession != null) {
            List<MCashMachine> lMachine = crud.getDataByID(mSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {
                
                boolean cacheSession = CSession.getInstance().endSession(mSession);
            
                if (cacheSession) {
                    MCashMachine machine = MCashMachine.Build()
                            .setCSM_ID(lMachine.get(0).getCSM_ID())
                            .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                            .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                            .setCSM_STATUS("AT");
                            
                    crud.update(machine);
                    
                    return true;
                }
            }
        }
    
        return false;
    }

}
