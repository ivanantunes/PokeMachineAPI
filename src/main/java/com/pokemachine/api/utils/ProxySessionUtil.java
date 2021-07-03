package com.pokemachine.api.utils;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.pokemachine.api.cache.CSession;
import com.pokemachine.api.interfaces.ProxyService;
import com.pokemachine.api.models.MSession;

/**
 * Proxy Service Session Util
 */
public class ProxySessionUtil implements ProxyService {
    
    /**
     * Constructor
     */
    private ProxySessionUtil() { }

    /**
     * Build a Class
     * @return Instance of Class
     */
    public static ProxySessionUtil Build() {
        return new ProxySessionUtil();
    }

    @Override
    public boolean newSession(MSession session) {
        return CSession.getInstance().newSession(session);
    }

    @Override
    public boolean authSession(MSession session) {
        return CSession.getInstance().authSession(session);
    }

    @Override
    public boolean endSession(MSession session) {
        return CSession.getInstance().endSession(session);
    }

}
