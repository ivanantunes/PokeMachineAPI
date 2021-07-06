package com.pokemachine.api.cache;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.crud.CashMachineCrud;

import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.models.MSession;

import ch.qos.logback.core.db.dialect.MsSQLDialect;

/**
 * Cache Session
 * @author gbrextreme
 * @author LucasZaia 
 */
public class CSession implements ProxyService{

    /**
     * Session List
     */
    private List<MSession> memorySession = new ArrayList<MSession>();

    /**
     * Instance of Class
     */
    private static CSession instance;
    
    /**
     * Constructor
     */
    private CSession() { }

    /**
     * Get instance method
     */
    public static CSession getInstance() {
        if (instance == null) {
            instance = new CSession();
        } 
        return instance;
    }

    /**
     * Dentroy instance method
     */
    public void destroyInstance() {
        instance = null;
    }

    /**
     * New Session
     * @param session - Value of MSession
     * @return boolean
     */
    public boolean newSession (MSession session) {
        // pegar conta e ver se tem alguma sessao
        MSession mSession = getSessionByCode(session.getSSI_ACC_CODE());

        //verificar se o token 
        if ((mSession != null) && (session.getSSI_TOKEN() != mSession.getSSI_TOKEN())) {

            mSession.setSSI_ACC_CODE(session.getSSI_ACC_CODE())
            .setSSI_CSM_ID(session.getSSI_CSM_ID())
            .setSSI_TOKEN(session.getSSI_TOKEN())
            .setSSI_DATE(LocalDateTime.now());    
            
            updateSession(mSession);

        } else {
            mSession.setSSI_DATE(LocalDateTime.now());
            updateSession(mSession);

        }

        return true;
    }
    

    /**
     * Authenticate Session
     * @param session - Value of MSession
     * @return boolean
     */
    public boolean authSession (MSession session) {

        MSession autSession = getSessionByToken(session.getSSI_TOKEN());

        if (autSession != null) {

            if ( ) {

            }

            //verificar hora e data
            // estar a data entre duas horas
                // se nao remover a sessaon
                // se sim continua e atualiza a data da sessao
            
            // atulizar a sessao

            return true;
        }

        return false;
    }

    /**
     * End Session
     * @param session - Value of MSession
     * @return boolean
     */
    public boolean endSession(MSession session) {
       
        removeSession(session.getSSI_ACC_CODE());
        return false;
    } 

    /**
     * GET Session by Code
     * @param code - Value of SSI_ACC_CODE
     * @return Obeject MSession
     */
    public MSession getSessionByCode(String code) {
        for ( MSession gSession : memorySession ) {
            if (gSession.getSSI_ACC_CODE().contains(code)) {
                return gSession;
            }
        }
        return null;    
    }

    /**
     * GET Session by Token
     * @param token - Value of Validation token
     * @return Obeject MSession
     */
    public MSession getSessionByToken(String token) {
        for ( MSession gSession : memorySession ) {
            if (gSession.getSSI_TOKEN().contains(token)) {
                return gSession;
            }
        }
        return null;    
    }

    /**
     * Insert Session
     * @param session - Value of MSession
     * @return boolean
     */
    public boolean insertSession(MSession session) {
        session.setSSI_DATE(LocalDateTime.now());
        memorySession.add(session);
        return true;
    } 

    /**
     * Update Session
     * @param session - Value of MSession
     * @return boolean
     */
    public boolean updateSession(MSession session) {
        for ( MSession uSession : memorySession ) {
            if (uSession.getSSI_ACC_CODE().contains(session.getSSI_ACC_CODE())) {
                uSession.setSSI_CSM_ID(session.getSSI_CSM_ID());
                uSession.setSSI_TOKEN(session.getSSI_TOKEN());
                uSession.setSSI_DATE(LocalDateTime.now());
                return true;
            }
        }    
        return false;
    }

    /**
     * Remove Session
     * @param code - Value of SSI_ACC_CODE
     * @return boolean
     */
    public boolean removeSession(String code) {
        for (MSession rSession : memorySession ){   
            if (rSession.getSSI_ACC_CODE().contains(code)){
                memorySession.remove(rSession);
                return true;
            }
        }
        return false;
    } 
}
