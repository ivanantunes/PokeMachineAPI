package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.ClientCrud;
import com.pokemachine.api.crud.ClientTelephoneCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MClient;
import com.pokemachine.api.models.MClientTelephone;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RClientTelephone implements RouterCrud<MClientTelephone> {
    
    /**
     * Crud Client Telephone
     */
    private ClientTelephoneCrud crud = ClientTelephoneCrud.getInstance();

    @Override
    @PostMapping("/register/telephone")
    public ResponseEntity<HttpMessage> register(@RequestBody MClientTelephone data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getCLT_TELEPHONE(), "Telefone", 20, 0);
        
        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (data.getCLT_CLI_ID() == 0) {
            message.setCode(code).setMessage("Cliente é Obrigatório.").setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {

            if (ClientCrud.getInstance().getDataByID(data.getCLT_CLI_ID()).size() != 1) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Cliente Não Encontrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }
            
            crud.insert(data);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Telefone Cadastrado com Sucesso.");

        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Cadastrado Telefone.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    @PostMapping("/edit/telephone")
    public ResponseEntity<HttpMessage> edit(@RequestBody MClientTelephone data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isValidSting(data.getCLT_TELEPHONE(), "Telefone", 20, 0);
        
        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (data.getCLT_CLI_ID() == 0) {
            message.setCode(code).setMessage("Cliente é Obrigatório.").setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (data.getCLT_ID() == 0) {
            message.setCode(code).setMessage("ID é Obrigatório.").setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            
            List<MClientTelephone> lTel = crud.getDataByID(data.getCLT_ID());

            if (lTel.size() != 1 || lTel.size() == 1 && lTel.get(0).getCLT_ID() != data.getCLT_ID()) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Telefone Não Encontrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            List<MClient> lClinets = ClientCrud.getInstance().getDataByID(data.getCLT_CLI_ID());

            if (lClinets.size() != 1 || lClinets.size() == 1 && lClinets.get(0).getCLI_ID() != data.getCLT_CLI_ID()) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Cliente Não Encontrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            crud.update(data);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Telefone Atualizado com Sucesso.");

        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Atualizar Telefone.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    @GetMapping("/delete/telephone")
    public ResponseEntity<HttpMessage> delete(@RequestParam int id) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;

        if (id == 0) {
            message.setCode(code).setMessage("ID é Obrigatório").setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            
            List<MClientTelephone> lTel = crud.getDataByID(id);

            if (lTel.size() == 0 || lTel.size() > 1 || lTel.size() == 1 && lTel.get(0).getCLT_ID() != id) {
                message.setCode(code).setMessage("Telefone Não Econtrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            crud.delete(id);
            code = HttpResponse.OK;
            message.setCode(code).setMessage("Telefone Deletado com Sucesso.");

        } catch (Exception e) {
            code = HttpResponse.BAD_REQUEST;
            message.setCode(code).setMessage("Falha ao Deletar Telefone.").setError(e.getMessage());
        }

        return ResponseEntity.status(code).body(message);
    }

    @Override
    public ResponseEntity<List<MClientTelephone>> getAll(String search) {
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MClientTelephone>> getFilteredData(int limit, String search) {
        return null;
    }

}
