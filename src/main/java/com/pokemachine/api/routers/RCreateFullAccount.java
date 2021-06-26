package com.pokemachine.api.routers;

import java.sql.Connection;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pokemachine.api.crud.AccountCrud;
import com.pokemachine.api.crud.AgencyCrud;
import com.pokemachine.api.crud.ClientAddressCrud;
import com.pokemachine.api.crud.ClientCrud;
import com.pokemachine.api.crud.ClientTelephoneCrud;
import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.database.DBService;
import com.pokemachine.api.http.HttpMessage;
import com.pokemachine.api.http.HttpResponse;
import com.pokemachine.api.interfaces.RouterCrud;
import com.pokemachine.api.models.MAccount;
import com.pokemachine.api.models.MClient;
import com.pokemachine.api.models.MClientAddress;
import com.pokemachine.api.models.MClientTelephone;
import com.pokemachine.api.validators.FloatValidator;
import com.pokemachine.api.validators.StringValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.crypto.bcrypt.*;

/**
 * Create a full account route that cotains all data
 * @author gbrextreme
 * @author LucasZaia
 */
@RestController
public class RCreateFullAccount implements RouterCrud<MAccount> {

    /**
     * Crud Client
     */
    private ClientCrud clientCrud = ClientCrud.getInstance();

    /**
     * Crud Client Telephone
     */
    private ClientTelephoneCrud telephoneCrud = ClientTelephoneCrud.getInstance();

    /**
     * Crud Client Addrres
     */
    private ClientAddressCrud addressCrud = ClientAddressCrud.getInstance();

    /**
     * Crud Account
     */
    private AccountCrud accountCrud = AccountCrud.getInstance();

    /**
     * Crud Agency
     */
    private AgencyCrud agencyCrud = AgencyCrud.getInstance();

    /**
     * Connection Database
     */
    private Connection connection = DBService.getInstance().getConnection();

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

    @PostMapping("/register/fullaccount")
    public ResponseEntity<HttpMessage> registerFullAccount(
        MClient clientData,
        MClientTelephone telephoneData,
        MClientAddress addressData,
        MAccount accountData) {


        HttpMessage message = HttpMessage.build();
        int code = HttpResponse.UNAUTHORIZED;
        String validator = "";
        
        validator = StringValidator.isValidSting(clientData.getCLI_FULL_NAME(), "Nome Completo", 80, 3);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(clientData.getCLI_RG(), "RG", 15, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(clientData.getCLI_CPF(), "CPF", 15, 14);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(clientData.getCLI_BIRTHDAY(), "Data de Aniversário", 10, 10);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(telephoneData.getCLT_TELEPHONE(), "Telefone", 20, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(addressData.getCLA_ZIP_CODE(), "CEP", 45, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(addressData.getCLA_ADDRESS(), "Endereço", 150, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isEmpty(String.valueOf(addressData.getCLA_NUMBER()), "Numero");
        
        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(addressData.getCLA_DISTRICTY(), "Bairro", 80, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(addressData.getCLA_CITY(), "Cidade", 80, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(addressData.getCLA_UF(), "UF", 2, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }


        validator = StringValidator.isValidSting(accountData.getACC_PASSWORD(), "Senha", 32, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isValidSting(accountData.getACC_TYPE(), "Tipo Conta", 2, 0);

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        if (!accountData.getACC_TYPE().contains("P") && !accountData.getACC_TYPE().contains("C") ) {
            message.setCode(code).setMessage("Tipo Conta está fora do padrão esperado.").setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = FloatValidator.isBigger(accountData.getACC_BALANCE(), 0, "Saldo");

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        validator = StringValidator.isEmpty(String.valueOf(accountData.getACC_AGE_ID()), "Agencia"); 

        if (!validator.isEmpty()) {
            message.setCode(code).setMessage(validator).setError("");
            return ResponseEntity.status(code).body(message);
        }

        try {
            connection.setAutoCommit(false);

            if (clientCrud.getAll(clientData.getCLI_RG()).size() != 0) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com RG " + clientData.getCLI_RG()).setError("");
                return ResponseEntity.status(code).body(message);
            }

            if (clientCrud.getAll(clientData.getCLI_CPF()).size() != 0) {
                message.setCode(code).setMessage("Cliente Já Cadastrado com CPF " + clientData.getCLI_CPF()).setError("");
                return ResponseEntity.status(code).body(message);
            }
            
            int clientID = clientCrud.insert(clientData);
            
            if (clientID > 0) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Cliente Não Encontrado.").setError("");
                return ResponseEntity.status(code).body(message);
            }

            telephoneData.setCLT_CLI_ID(clientID);
            telephoneCrud.insert(telephoneData);

            addressData.setCLA_CLI_ID(clientID);
            addressCrud.insert(addressData);

            if (agencyCrud.getDataByID(accountData.getACC_AGE_ID()).size() <= 0) {
                code = HttpResponse.NOT_FOUND;
                message.setCode(code).setMessage("Agencia Não Encontrado.").setError("");
                return ResponseEntity.status(code).body(message);    
            }

            // String hashPassword = BCrypt.hashpw(accountData.getACC_PASSWORD(), BCrypt.gensalt());
            
            accountData.setACC_PASSWORD(accountData.getACC_PASSWORD());
            accountData.setACC_CLI_ID(clientID);
            accountCrud.insert(accountData);

            connection.commit();
            connection.setAutoCommit(true);

            code = HttpResponse.OK;
            message.setCode(code).setMessage("Conta Completa Cadastrado com Sucesso.");
            return ResponseEntity.status(code).body(message);
        } catch (Exception e) {
            try {
                code = HttpResponse.BAD_REQUEST;
                message.setCode(code).setMessage("Falha ao Cadastrado da Conta Completa").setError(e.getMessage());
                connection.rollback();
                connection.setAutoCommit(true);
                return ResponseEntity.status(code).body(message); 
            } catch (Exception err) {
                code = HttpResponse.INTERNAL_SERVER_ERROR;
                message.setCode(code).setMessage("Erro Interno do Servidor.").setError(err.getMessage());
                return ResponseEntity.status(code).body(message);
            }
        }
    }
    
}
