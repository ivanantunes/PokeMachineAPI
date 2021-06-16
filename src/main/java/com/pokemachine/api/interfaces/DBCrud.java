package com.pokemachine.api.interfaces;

import java.util.List;

import com.pokemachine.api.database.DBResult;

/**
 * Abstract Crud and Methods
 * @author ivanantunes
 */
public interface DBCrud<X> {
    
    /**
     * Insert into Database
     * @param value - Value insert into database
     * @return ID inserted into database
     */
    public abstract int insert(X value);

    /**
     * Update value of Database
     * @param value - Value to update
     * @return New Value Update
     */
    public abstract X update(X value);

    /**
     * Delete value of Database
     * @param id - ID to delete
     */
    public abstract void delete(int id);

    /**
     * Get All Data
     * @param search - Search Value
     * @return List of Data
     */
    public abstract List<X> getAll(String search);

    /**
     * Get Filtered Data
     * @param limit - Limit of Rows
     * @param search - Search Value
     * @return List of Data
     */
    public abstract DBResult<X> getFilteredData(int limit, String search);

    /**
     * Get Data by ID
     * @param id - ID of Data
     * @return List of Data
     */
    public abstract List<X> getDataByID(int id);

}
