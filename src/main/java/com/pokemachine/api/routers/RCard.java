package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MCard;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RCard implements RouterCrud<MCard> {


    @PostMapping("/ask/card")
    public ResponseEntity<HttpMessage> randomNumber(@RequestBody MCard data) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isEmpty(String.valueOf(data.getCAR_ACC_ID()), "ID Conta");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isMaxLength(data.getCAR_PASSWORD(), "Senha", 4);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(data.getCAR_TYPE(), "Tipo Cartão", 1, 2);
        
        // Salvar

        


        return ResponseEntity.status(code).body(message);
    }

    @Override
    public ResponseEntity<HttpMessage> register(MCard data) {
        
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> edit(MCard data) {
       
        return null;
    }

    @Override
    public ResponseEntity<HttpMessage> delete(int id) {
        
        return null;
    }

    @Override
    public ResponseEntity<List<MCard>> getAll(String search) {
        
        return null;
    }

    @Override
    public ResponseEntity<DBResult<MCard>> getFilteredData(int limit, String search) {
        
        return null;
    }
    
}
