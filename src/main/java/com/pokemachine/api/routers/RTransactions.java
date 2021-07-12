package com.pokemachine.api.routers;

import java.util.List;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.forms.FDebit;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MSession;
import com.pokemachine.api.models.MTransferHistory;
import com.pokemachine.api.utils.ProxySessionUtil;
import com.pokemachine.api.validators.FloatValidator;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create a Transactions route 
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RTransactions  {
    
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

    @CrossOrigin
    @PostMapping("/transfer/credit")
    public ResponseEntity<HttpMessage> credit(@RequestBody float value, @RequestHeader String token
    ) {
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";
        
        validator = StringValidator.isEmpty(token, "Token de Sessão");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = FloatValidator.isSmaller(value, 0, "Valor de Transferência");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try{
            MSession session = MSession.Build().setSSI_TOKEN(token);

            if (!ProxySessionUtil.getInstance().authSession(session)) {
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Sessão invalida ou expirada.").setError("");
                return ResponseEntity.status(code).body(message);
            }
            
            MAccount account = ProxySessionUtil.getInstance()
                .getAccountByToken(session);

            account.setACC_BALANCE(account.getACC_BALANCE() + value);
            accountCrud.update(account);

            code = HttpResponse.OK;
            message.setCode(code).setMessage("Valor de R$ " + value + " credita com sucesso.").setError("");
            return ResponseEntity.status(code).body(message);
        }catch (Exception e) {
           code = HttpResponse.INTERNAL_SERVER_ERROR;
           message.setCode(code).setMessage("Erro interno no servidor").setError(e.getMessage());
           return ResponseEntity.status(code).body(message);      
        }
    }

}
