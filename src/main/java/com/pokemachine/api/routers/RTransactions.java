package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.forms.FDebit;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create a Transactions route 
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RTransactions implements RouterCrud<MSession> {
    
    /**
     * Cash Machine Crud
     */
    private CashMachineCrud cashMachineCrud = CashMachineCrud.getInstance();

    /**
     * Account Crud
     */
    private AccountCrud accountCrud = AccountCrud.getInstance();

    @CrossOrigin
    @PostMapping("debit")
    public ResponseEntity<HttpMessage> debit(@RequestBody FDebit data){
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";
        
        try{

        }catch (Exception e) {
           code = HttpResponse.INTERNAL_SERVER_ERROR;
           message.setCode(code).setMessage("Erro interno no servidor").setError(e.getMessage());
           return ResponseEntity.status(code).body(message);      
        }
        
        return null;

    }
    

    @Override
    public ResponseEntity<HttpMessage> register(MSession data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> edit(MSession data) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ResponseEntity<HttpMessage> delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ResponseEntity<List<MSession>> getAll(String search) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ResponseEntity<DBResult<MSession>> getFilteredData(int limit, String search) {
        // TODO Auto-generated method stub
        return null;
    } 



}