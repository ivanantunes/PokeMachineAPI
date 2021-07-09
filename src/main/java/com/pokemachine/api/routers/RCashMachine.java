package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MCashMachine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RCashMachine implements RouterCrud<MCashMachine> {

    /**
     * Crud CashMachine
     */
    private CashMachineCrud cashMachineCrud = CashMachineCrud.getInstance();

    @Override
    @CrossOrigin
    @GetMapping("/all/cashMachine")
    public ResponseEntity<List<MCashMachine>> getAll(String search) {
        int code = HttpResponse.UNAUTHORIZED;

        try {
            code = HttpResponse.OK;
            return ResponseEntity.status(code).body(cashMachineCrud.getAll(search));
        } catch (Exception e) {
            code = HttpResponse.INTERNAL_SERVER_ERROR;
            return ResponseEntity.status(code).body(null);
        }

    }

    @Override
    public ResponseEntity<HttpMessage> register(MCashMachine data) {
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> edit(MCashMachine data) {
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> delete(int id) {
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MCashMachine>> getFilteredData(int limit, String search) {
        return null;
    }

}
