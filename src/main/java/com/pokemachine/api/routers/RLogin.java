package com.pokemachine.api.routers;

import java.util.List;

import javax.servlet.http.HttpSessionListener;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.ClientCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Session;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

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
    public ResponseEntity<HttpMessage> login(@RequestBody MAccount data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getACC_CODE(), "Codigo Conta", 15, 1);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getACC_PASSWORD(), "Senha", 32, 6);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            List<MAccount> lAccounts = accountCrud.getAll(data.getACC_CODE());

            if (lAccounts.size() >= 2) {
                code = HttpResponse.INTERNAL_SERVER_ERROR;
                message.setCode(code).setMessage("Mais de uma conta foi encontrada com o numero informado.")
                        .setError("");
                return ResponseEntity.status(code).body(message);
            } else if (lAccounts.size() <= 0) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Nenhuma Conta encontrado com o numero informado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            String hashPassword = BCrypt.withDefaults().hashToString(12, data.getACC_PASSWORD().toCharArray());

            if (hashPassword != lAccounts.get(0).getACC_PASSWORD()) {
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Senha invalida ou não coincidem.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            // TODO: Mater sessão

            HttpHeaders headers = new HttpHeaders();
            headers.add("session-value", "");

            code = HttpResponse.OK;
            message.setCode(code).setMessage("Login efetuado com sucesso.").setError("");
            return ResponseEntity.status(code).headers(headers).body(message);

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
