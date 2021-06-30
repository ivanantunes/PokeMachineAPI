package com.pokemachine.api.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.EncryptedPrivateKeyInfo;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MCashMachine;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Session implements ProxyService {

    /**
     * 
     */
    private List<FLogin> SESSIONS = new ArrayList<FLogin>();

    private AccountCrud accountcrud = AccountCrud.getInstance();

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
        // TODO Auto-generated method stub

        // validar a conta
        List<MAccount> laccount = accountcrud.getAll(data.getCODE());

        if (laccount.size() >= 2) {
            return false;
        } else if (laccount.size() <= 0) {
            return false;
        }

        String hashpassword = BCrypt.withDefaults().hashToString(12, data.getPASSWORD().toCharArray());

        if (laccount.get(0).getACC_PASSWORD() != hashpassword) {

            return false;
        }

        List<MCashMachine> lCashMachine = cashMachineCrud.getDataByID(data.getCASH_MACHINE_ID());

        if (lCashMachine.size() >= 2) {
            return false;
        } else if (lCashMachine.size() <= 0) {
            return false;
        }

        if (SESSIONS.contains(data)) {
            if (SESSIONS.get(0).getCODE() == data.getCODE() && SESSIONS.get(0).getPASSWORD() == data.getPASSWORD()
                    && SESSIONS.get(0).getCASH_MACHINE_ID() == data.getCASH_MACHINE_ID()) {
                return true;
            } else {
                return false;
            }
        } else {
            SESSIONS.add(data);
        }
        // se exiter valide se os dados sao iguais
        // se forem iguais passa
        // se nao erro
        // se nao existir passa pra gravar

        // alteraçoes dentro dos caixas
        // status

        // salva nas sessoes

        // retorna true

        return true;

    }

    @Override
    public boolean authSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean endSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

}
