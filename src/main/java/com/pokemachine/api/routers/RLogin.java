package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.utils.ProxyUtil;
import com.pokemachine.api.validators.FloatValidator;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create a login route that login data
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RLogin implements RouterCrud<MAccount> {
    
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<HttpMessage> login(@RequestBody FLogin data)  {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getCODE(), "Codigo Conta", 15, 1);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getPASSWORD(), "Senha", 32, 6);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);    
        }

        validator = FloatValidator.isSmaller(data.getCASH_MACHINE_ID(), 0, "Caixa Eletronico");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);    
        }

        validator = StringValidator.isEmpty(data.getTOKEN(), "Token");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            
            if (ProxyUtil.Build().startSession(data)) {
                code = HttpResponse.OK;
                message.setCode(code).setMessage("Login efetuado com sucesso.").setError("");
                return ResponseEntity.status(code).body(message);
            } else {
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Falha ao efetuar login.").setError("");
                return ResponseEntity.status(code).body(message);
            }

        } catch (Exception e) {
            try {
                code = HttpResponse.BAD_REQUEST;
                message.setCode(code).setMessage("Falha ao efetuar login.").setError(e.getMessage());
                return ResponseEntity.status(code).body(message);
            } catch (Exception err) {
                code = HttpResponse.INTERNAL_SERVER_ERROR;
                message.setCode(code).setMessage("Erro Interno do Servidor.").setError(err.getMessage());
                return ResponseEntity.status(code).body(message);
            }
        }
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
