package com.pokemachine.api.interfaces;

import java.util.List;

import com.pokemachine.api.database.DBResult;
import com.pokemachine.api.http.HttpMessage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract Crud routers
 * @author ivanantunes
 */
public interface RouterCrud<X> {
    
    /**
     * Register
     * @param data - Data of Register
     * @return Http Message
     */
    public abstract ResponseEntity<HttpMessage> register(@RequestBody X data);

    /**
     * Edit
     * @param data - Data of Edit
     * @return Http Message
     */
    public abstract ResponseEntity<HttpMessage> edit(@RequestBody X data);

    /**
     * Delete
     * @param id - ID of Delete
     * @return Http Message
     */
    public abstract ResponseEntity<HttpMessage> delete(@RequestBody int id);

    /**
     * Get All
     * @param search - Search data
     * @return List of data
     */
    public abstract ResponseEntity<List<X>> getAll(String search);

    /**
     * Get Filtered Data
     * @param limit - Limit data
     * @param search - Search data
     * @return List of data
     */
    public abstract ResponseEntity<DBResult<X>> getFilteredData(@RequestBody int limit, @RequestBody String search);

}
