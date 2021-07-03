package com.pokemachine.api.cache;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.pokemachine.api.crud.CashMachineCrud;
import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MCashMachine;
import com.pokemachine.api.models.MSession;

public class CSession implements ProxyService{

    private CashMachineCrud crud = CashMachineCrud.getInstance();

    private List<MSession> memorySession = new ArrayList<MSession>();

    public boolean newSession (MSession session) {

        List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

        if (lMachine.size() >= 1) {
            if (lMachine.get(0).getCSM_STATUS().contains("EU") || lMachine.get(0).getCSM_STATUS().contains("IN")) {
                return false;
            }

            try {
                lMachine.get(0).setCSM_STATUS("EU");
                crud.update(lMachine.get(0));

                if (updateSession(session)) {
                    return true;
                } else {
                    insertSession(session);
                }

            } catch(Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean authSession (MSession session) {

        List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

        if (lMachine.size() >= 1) {

            MSession autSession = getSessionByCode(session.getSSI_ACC_CODE());

            if (autSession != null) {

                if (autSession.getSSI_TOKEN() == session.getSSI_TOKEN() ) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean endSession(MSession session) {
        List<MCashMachine> lMachine = crud.getDataByID(session.getSSI_CSM_ID());

        if (lMachine.size() >= 1) {

            try {
                lMachine.get(0).setCSM_STATUS("AT");

                crud.update(lMachine.get(0));
                removeSession(session.getSSI_ACC_CODE());

            } catch (Exception e) {
                return false;
            }    
        }

        return false;
    } 

    public MSession getSessionByCode(String code) {
        for ( MSession uSession : memorySession ) {
            if (uSession.getSSI_ACC_CODE().contains(code)) {
                return uSession;
            }
        }
        return null;    
    }

    public boolean insertSession(MSession session) {
        session.setSSI_DATE(LocalDateTime.now());
        memorySession.add(session);
        return true;
    } 

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
