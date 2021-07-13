package com.pokemachine.api.routers;

import java.sql.Connection;

import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MCashMachine;
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

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

    @CrossOrigin
    @PostMapping("/transfer/debit")
    public ResponseEntity<HttpMessage> debit(@RequestBody float value, 
    @RequestHeader String token){
        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";

        validator = StringValidator.isEmpty(token,"Token Session");

        if(!validator.isEmpty()){
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = FloatValidator.isSmaller(value,0,"Valor Debitado");

        if(!validator.isEmpty()){
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);  
        }
        
        try{
            
            connection.setAutoCommit(false);

            if (!ProxySessionUtil.getInstance().authSession(token)){
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Sessão Inválida ou Expirada").setError("");
                return ResponseEntity.status(code).body(message);
            }

            MCashMachine cashMachine = ProxySessionUtil.getInstance().getCashMachineByToken(token);

            if(cashMachine.getCSM_AVAILABLE_VALUE() < value){
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Caixa Eletrônico Está sem dinheiro suficiente").setError("");
                return ResponseEntity.status(code).body(message);
            } 

            MAccount account = ProxySessionUtil.getInstance().getAccountByToken(token);

            if(account.getACC_BALANCE() < value){
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Conta não possui saldo suficiente para completar operação").setError("");
                return ResponseEntity.status(code).body(message);
            }
            
            account.setACC_BALANCE(account.getACC_BALANCE() - value);
            accountCrud.update(account);

            cashMachine.setCSM_AVAILABLE_VALUE(cashMachine.getCSM_AVAILABLE_VALUE() - value);
            cashMachineCrud.update(cashMachine);

            connection.commit();
            connection.setAutoCommit(true);

            if(account.getACC_BALANCE() <= 0){
                account.setACC_STATUS(false);
                accountCrud.update(account);
                String msgDebit = "Valor R$ " + value + " Debitado";
                String msgErr = "sua conta foi desativada por estar com saldo zerado";
                message.setCode(code).setMessage(msgDebit).setError(msgErr);
                return ResponseEntity.status(code).body(message);
            } 

            code = HttpResponse.OK;
            message.setCode(code).setMessage("Valor R$ " + value + " foi Debitado com sucesso");
            return ResponseEntity.status(code).body(message);
            
        }catch (Exception e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                code = HttpResponse.BAD_REQUEST;
                message.setCode(code).setMessage("Falha ao efetuar transação de Débito.").setError(e.getMessage());
                return ResponseEntity.status(code).body(message);
            } catch (Exception err) {
                code = HttpResponse.INTERNAL_SERVER_ERROR;
                message.setCode(code).setMessage("Erro Interno do Servidor.").setError(err.getMessage());
                return ResponseEntity.status(code).body(message);
            }
        }
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
            connection.setAutoCommit(false);

            if (!ProxySessionUtil.getInstance().authSession(token)) {
                code = HttpResponse.UNAUTHORIZED;
                message.setCode(code).setMessage("Sessão invalida ou expirada.").setError("");
                return ResponseEntity.status(code).body(message);
            }
            
            MAccount account = ProxySessionUtil.getInstance().getAccountByToken(token);

            if (!account.getACC_STATUS()) {
                float balance = account.getACC_BALANCE() + value;
                if (balance > 0) {
                    account.setACC_STATUS(true);
                }
            }

            account.setACC_BALANCE(account.getACC_BALANCE() + value);
            accountCrud.update(account);

            MCashMachine cashMachine = ProxySessionUtil.getInstance().getCashMachineByToken(token);

            cashMachine.setCSM_AVAILABLE_VALUE(cashMachine.getCSM_AVAILABLE_VALUE() + value);
            cashMachineCrud.update(cashMachine);

            connection.commit();
            connection.setAutoCommit(true);

            code = HttpResponse.OK;
            message.setCode(code).setMessage("Valor de R$ " + value + " credita com sucesso.").setError("");
            return ResponseEntity.status(code).body(message);
        }catch (Exception e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                code = HttpResponse.BAD_REQUEST;
                message.setCode(code).setMessage("Falha ao efetuar transação de credito.").setError(e.getMessage());
                return ResponseEntity.status(code).body(message);
            } catch (Exception err) {
                code = HttpResponse.INTERNAL_SERVER_ERROR;
                message.setCode(code).setMessage("Erro Interno do Servidor.").setError(err.getMessage());
                return ResponseEntity.status(code).body(message);
            }
        }
    }

}
