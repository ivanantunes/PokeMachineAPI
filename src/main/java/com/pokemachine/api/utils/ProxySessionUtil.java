package com.pokemachine.api.utils;

import java.util.List;

import com.pokemachine.api.cache.CSession;
import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.models.MSession;

/**
 * Proxy Service Session Util
 */
public class ProxySessionUtil implements ProxyService {
    

    /**
     * Cash Machine Crud Instance
     */
    private CashMachineCrud cashMachinecrud = CashMachineCrud.getInstance();

    /**
     * Account Crud
     */
    private AccountCrud accountCrud = AccountCrud.getInstance();

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

        List<MCashMachine> lMachine = cashMachinecrud.getDataByID(session.getSSI_CSM_ID());

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
                    List<MCashMachine> lMachineOld = cashMachinecrud.getDataByID(isSession.getSSI_CSM_ID());

                    MCashMachine oldMachine = MCashMachine.Build()
                        .setCSM_ID(lMachineOld.get(0).getCSM_ID())
                        .setCSM_NAME(lMachineOld.get(0).getCSM_NAME())
                        .setCSM_AVAILABLE_VALUE(lMachineOld.get(0).getCSM_AVAILABLE_VALUE())
                        .setCSM_STATUS("AT");
    
                    cSession.removeSessionByToken(isSession.getSSI_TOKEN());
                    cashMachinecrud.update(oldMachine);
                }
                cashMachinecrud.update(currentMachine);

                return cSession.newSession(session);
            } else {
                boolean cacheSession = CSession.getInstance().newSession(session);

                if (cacheSession) {
    
                    MCashMachine machine = MCashMachine.Build()
                    .setCSM_ID(lMachine.get(0).getCSM_ID())
                    .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                    .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                    .setCSM_STATUS("EU"); 
                    
                    cashMachinecrud.update(machine);
    
                    return true;
                }
        
            }

        }

        return false;
    }

    @Override
    public boolean authSession(MSession session) {
        MSession cacheSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (cacheSession != null) {
            List<MCashMachine> lMachine = cashMachinecrud.getDataByID(cacheSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {

                if (CSession.getInstance().authSession(cacheSession)) {
                    return true;
                }

                MCashMachine machine = MCashMachine.Build()
                    .setCSM_ID(lMachine.get(0).getCSM_ID())
                    .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                    .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                    .setCSM_STATUS("AT");

                cashMachinecrud.update(machine);
                return false;
            }
        }
        
        return false;
    }

    @Override
    public boolean endSession(MSession session) {
        MSession cacheSession = CSession.getInstance().getSessionByToken(session.getSSI_TOKEN()); //pegar caixa pelo token da sessao

        if (cacheSession != null) {
            List<MCashMachine> lMachine = cashMachinecrud.getDataByID(cacheSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {
                
                boolean endSession = CSession.getInstance().endSession(cacheSession);
            
                if (endSession) {
                    MCashMachine machine = MCashMachine.Build()
                            .setCSM_ID(lMachine.get(0).getCSM_ID())
                            .setCSM_NAME(lMachine.get(0).getCSM_NAME())
                            .setCSM_AVAILABLE_VALUE(lMachine.get(0).getCSM_AVAILABLE_VALUE())
                            .setCSM_STATUS("AT");
                            
                    cashMachinecrud.update(machine);
                    return true;
                }
            }
        }
    
        return false;
    }

    @Override
    public MAccount getAccountByToken(MSession session) {        
        MAccount mAccount = CSession.getInstance().getAccountByToken(session);

        if (mAccount != null) {
            try{
                return accountCrud.getDataByCode(mAccount.getACC_CODE());
            } catch (Exception e) {
                SystemUtil.log("Proxy error while trying to get Account by Token " + e.getMessage());
            }
        }

        return null;
    }

    
    

}
