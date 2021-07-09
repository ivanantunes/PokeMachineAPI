package com.pokemachine.api.interfaces;

import com.pokemachine.api.models.MSession;

/**
 * Abstract Proxy Services
 * @author gbrextreme
 */
public interface ProxyService {
    
    /**
     * New Session 
     * @param session - Model of Session
     * @return Value of Method
     */
    public boolean newSession (MSession session);

    /**
     * Authenticate Session
     * @param session - Model of Session
     * @return Value of Method
     */
    public boolean authSession (MSession session);

    /**
     * Finalize Session
     * @param session - Model of Session
     * @return Value of Method
     */
    public boolean endSession(MSession session);

}
