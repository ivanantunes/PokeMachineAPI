package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.utils.SystemUtil;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Account route contains the basic crud.
 * 
 * @author LucasZaia
 */
public class RAccount implements RouterCrud<MAccount> {

    private AccountCrud crud = AccountCrud.getInstance();

    @Override
    @PostMapping("/register/account")
    public ResponseEntity<HttpMessage> register(@RequestBody MAccount data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getACC_PASSWORD(), "Senha", 100, 6);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getACC_TYPE(), "Tipo de Conta", 1, 1);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {

            if (crud.getAll(data.getACC_CODE()).size() != 0) {
                message.setCode(code).setMessage("Essa Conta já existe" + data.getACC_CODE()).setError(""));
                return ResponseEntity.status(code).body(message);
            }
        }catch(Exception e){
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao criar Conta").getError();
        }

        return ResponseEntity.status(code).body(message);
    }
    

    @Override
    public ResponseEntity<HttpMessage> edit(MAccount data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<MAccount>> getAll(String search) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MAccount>> getFilteredData(int limit, String search) {
        // TODO Auto-generated method stub
        return null;
    }

}