package com.pokemachine.api.utils;

import com.pokemachine.api.forms.FLogin;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.proxy.Session;

public class ProxyUtil implements ProxyService {

    /**
     * Constructor
     */
    private ProxyUtil() { }

    /**
     * Build Class
     * @return Instance of Class ProxyUtil
     */
    public static ProxyUtil Build() {
        return new ProxyUtil();
    }

    @Override
    public boolean startSession(FLogin data) {
        return Session.getInstance().startSession(data);
    }

    @Override
    public boolean authSession(FLogin data) {
        return Session.getInstance().authSession(data);
    }

    @Override
    public boolean endSession(FLogin data) {
        return Session.getInstance().endSession(data);
    }
    
}
