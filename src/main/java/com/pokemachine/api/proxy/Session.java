package com.pokemachine.api.proxy;

import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.utils.SystemUtil;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Sesssion Class
 * @author gbrextreme
 * @author lucaszaia
 */
public class Session implements ProxyService {

    /**
     * List Sessions
     */
    private List<FLogin> lSession = new ArrayList<FLogin>();

    /**
     * Account Crud
     */
    private AccountCrud accountcrud = AccountCrud.getInstance();

    /**
     * Cash Machine Crud
     */
    private CashMachineCrud cashMachineCrud = CashMachineCrud.getInstance();

    /**
     * Instance of Class
     */
    private static Session instance;

    /**
     * Constructor
     */
    private Session() {
    }

    /**
     * Get Instance
     * 
     * @return Instance of Class
     */
    public static Session getInstance() {
        if (Session.instance == null) {
            Session.instance = new Session();
        }
        return Session.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        Session.instance = null;
    }

    @Override
    public boolean startSession(FLogin data) {
        
        try {
            MAccount account = accountcrud.getDataByCode(data.getCODE());
        
            if (account == null) {
                return false; //Não foi encontrado nenhuma conta
            }

            int salt = 12;
            char[] charLoginPassword = data.getPASSWORD().toCharArray();
            char[] charAccountPassword = account.getACC_PASSWORD().toCharArray(); 
            char[] hashpassword = BCrypt.withDefaults().hashToChar(salt, charLoginPassword);
            
            if (BCrypt.verifyer().verify(charAccountPassword, hashpassword).verified == false) {
                return false; //Senhas não conferem
            }

            data.setPASSWORD(hashpassword.toString());

            List<MCashMachine> lCashMachine = cashMachineCrud.getDataByID(data.getCASH_MACHINE_ID());

            if (lCashMachine.size() != 1 || lCashMachine.get(0).getCSM_ID() != data.getCASH_MACHINE_ID()) {
                return false; // caixa eletronico nao existe
            }

            FLogin foundUser = null;
            for (FLogin user: lSession) {

                if (user.equals(data)) {
                    foundUser = user;

                    lCashMachine.get(0).setCSM_STATUS("EN");
                    cashMachineCrud.update(lCashMachine.get(0));
                    
                    user.setCODE(data.getCODE())
                        .setPASSWORD(data.getPASSWORD())
                        .setCASH_MACHINE_ID(data.getCASH_MACHINE_ID())
                        .setTOKEN(data.getTOKEN());
                    
                    return true;
                }

            }

            if (foundUser == null) {    
                lSession.add(data);                
                return true;
            }

            return false;
        } catch (Exception e) {
            SystemUtil.log("Falha ao iniciar sessão.");
            return false;
        }
    }

    @Override
    public boolean authSession(FLogin data) {
        return false;
    }

    @Override
    public boolean endSession(FLogin data) {
        return false;
    }

}
