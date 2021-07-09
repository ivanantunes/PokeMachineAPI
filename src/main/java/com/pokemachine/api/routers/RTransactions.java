package com.pokemachine.api.routers;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.interfaces.RouterCrud;

import org.springframework.web.bind.annotation.RestController;

/**
 * Create a Transactions route 
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RTransactions implements RouterCrud<> {
    
    /**
     * Cash Machine Crud
     */
    private CashMachineCrud cashMachineCrud = CashMachineCrud.getInstance();

    /**
     * Account Crud
     */
    private AccountCrud accountCrud = AccountCrud.getInstance(); 



}
