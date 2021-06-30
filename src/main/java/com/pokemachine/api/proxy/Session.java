package com.pokemachine.api.proxy;

import java.util.ArrayList;
import java.util.List;

import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;

public class Session implements ProxyService {
    
    /**
     * 
     */
    private List<FLogin> SESSIONS = new ArrayList<FLogin>();

    /**
     * Instance of Class
     */
    private static Session instance;
    
    /**
     * Constructor
     */
    private Session() { }

    /**
     * Get Instance
     * @return Instance of Class
     */
    public static Session getInstance() {
        if (Session.instance == null) {
            Session.instance = new Session();
        }
        return Session.instance;
    }

    /**
     * Destroy Instance
     */
    public static void destroyInstance() {
        Session.instance = null;
    }

    @Override
    public boolean startSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean authSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean endSession(FLogin data) {
        // TODO Auto-generated method stub
        return false;
    }
  
}
