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
    public boolean authSession(String token) {
        MSession cacheSession = CSession.getInstance().getSessionByToken(token); 

        if (cacheSession != null) {
            List<MCashMachine> lMachine = cashMachinecrud.getDataByID(cacheSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {

                if (CSession.getInstance().authSession(cacheSession.getSSI_TOKEN())) {
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
    public boolean endSession(String token) {
        MSession cacheSession = CSession.getInstance().getSessionByToken(token); //pegar caixa pelo token da sessao

        if (cacheSession != null) {
            List<MCashMachine> lMachine = cashMachinecrud.getDataByID(cacheSession.getSSI_CSM_ID());

            if (lMachine.size() == 1) {
                
                boolean endSession = CSession.getInstance().endSession(cacheSession.getSSI_TOKEN());
            
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
    public MAccount getAccountByToken(String token) {        
        MAccount account = CSession.getInstance().getAccountByToken(token);

        if (account != null) {
            try{
                return accountCrud.getDataByCode(account.getACC_CODE());
            } catch (Exception e) {
                SystemUtil.log("Proxy error while trying to get Account by Token " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public MCashMachine getCashMachineByToken(String token) {
        MCashMachine cashMachine = CSession.getInstance().getCashMachineByToken(token);

        if (cashMachine != null) {
            try {
                List<MCashMachine> lCashMachines = cashMachinecrud.getDataByID(cashMachine.getCSM_ID());

                if (lCashMachines.size() == 1) {
                    cashMachine.setCSM_ID(lCashMachines.get(0).getCSM_ID())
                        .setCSM_NAME(lCashMachines.get(0).getCSM_NAME())
                        .setCSM_AVAILABLE_VALUE(lCashMachines.get(0).getCSM_AVAILABLE_VALUE())
                        .setCSM_STATUS(lCashMachines.get(0).getCSM_STATUS());
                    return cashMachine;
                }

            } catch (Exception e) {
                SystemUtil.log("Proxy error while trying to get Cash Machine by Token " + e.getMessage());
            }
        } 
        return null;
    }

    
    

}
