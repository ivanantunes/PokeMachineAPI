package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.ClientCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create a full account route that cotains all data
 * 
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RLogin implements RouterCrud<MAccount> {

    /**
     * Crud Client
     */
    private ClientCrud clientCrud = ClientCrud.getInstance();

    /**
     * Crud Account
     */
    private AccountCrud accountCrud = AccountCrud.getInstance();

    @PostMapping("/login")
    public ResponseEntity<HttpMessage> login(@RequestBody MAccount data)  {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";
        
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> register(MAccount data) {
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> edit(MAccount data) {
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> delete(int id) {
        return null;
    }

    @Override
    public ResponseEntity<List<MAccount>> getAll(String search) {
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MAccount>> getFilteredData(int limit, String search) {
        return null;
    }
    
}
