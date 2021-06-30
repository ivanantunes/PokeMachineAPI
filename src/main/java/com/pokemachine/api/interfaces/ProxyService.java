package com.pokemachine.api.interfaces;

import com.pokemachine.api.forms.FLogin;

/**
 * Abstract Proxy Services
 * @author gbrextreme
 */
public interface ProxyService {

    /**
     * Start session
     * @param data - data of Session
     * @return result of function
     */
    public boolean startSession(FLogin data);

    /**
     * Authenticate Session
     * @param data - data of Session
     * @return result of function
     */
    public boolean authSession(FLogin data);
    
    /**
     * Finalize a session
     * @param data - data of Session
     * @return result of function
     */
    public boolean endSession(FLogin data);     
}
