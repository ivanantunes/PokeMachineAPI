package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.ClientCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MClient;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Client route contains the basic crud.
 * @author ivanantunes
 */
@RestController
public class RClient implements RouterCrud<MClient> {
    
    /**
     * Crud Client
     */
    private ClientCrud crud = ClientCrud.getInstance();

    @Override
    @PostMapping("/register/client")
    public ResponseEntity<HttpMessage> register(@RequestBody MClient data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getCLI_FULL_NAME(), "Nome Completo", 80, 3);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_RG(), "RG", 15, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_CPF(), "CPF", 15, 14);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_BIRTHDAY(), "Data de Aniversário", 8, 8);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            if (crud.getAll(data.getCLI_RG()).size() != 0) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com RG " + data.getCLI_RG()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            if (crud.getAll(data.getCLI_CPF()).size() != 0) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com CPF " + data.getCLI_CPF()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            crud.insert(data);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Cliente Cadastrado com Sucesso.");
        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Cadastrado Cliente.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    @PostMapping("/edit/client")
    public ResponseEntity<HttpMessage> edit(@RequestBody MClient data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getCLI_FULL_NAME(), "Nome Completo", 80, 3);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_RG(), "RG", 15, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_CPF(), "CPF", 15, 14);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCLI_BIRTHDAY(), "Data de Aniversário", 8, 8);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (data.getCLI_ID() == 0) {
            message.setCode(code).setMessage("ID é Obrigatório").setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            List<MClient> lClients = crud.getDataByID(data.getCLI_ID());

            if (lClients.size() != 1 || lClients.size() == 1 && lClients.get(0).getCLI_ID() != data.getCLI_ID()) {
                message.setCode(code).setMessage("Cliente Não Econtrado com ID " + data.getCLI_ID()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            lClients = crud.getAll(data.getCLI_RG());
            
            if (lClients.size() != 1 || lClients.size() == 1 && lClients.get(0).getCLI_ID() != data.getCLI_ID()) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com RG " + data.getCLI_RG()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            lClients = crud.getAll(data.getCLI_CPF());

            if (lClients.size() != 1 || lClients.size() == 1 && lClients.get(0).getCLI_ID() != data.getCLI_ID()) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com CPF " + data.getCLI_CPF()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            crud.update(data);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Cliente Editado com Sucesso.");
        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Editar Cliente.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    @GetMapping("/delete/client")
    public ResponseEntity<HttpMessage> delete(@RequestParam int id) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;

        if (id == 0) {
            message.setCode(code).setMessage("ID é Obrigatório").setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            
            List<MClient> client = crud.getDataByID(id);

            if (client.size() != 1 || client.size() == 1 && client.get(0).getCLI_ID() != id) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Cliente Não Econtrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            crud.delete(id);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Cliente Deletado com Sucesso.");

        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Deletar Cliente.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    public ResponseEntity<List<MClient>> getAll(String search) {
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MClient>> getFilteredData(int limit, String search) {
        return null;
    } 

}
