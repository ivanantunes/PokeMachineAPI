package com.pokemachine.api.database;

import java.util.List;

/**
 * Class of Result Searchs Database
 * @author ivanantunes
 */
public class DBResult<X> {

    /**
     * Total of Items
     */
    private int totalItems;

    /**
     * List of Items
     */
    private List<X> items;

    /**
     * Constructor
     */
    public DBResult() { }

    /**
     * Get Total Items
     * @return Total Items
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Set Total Items
     * @param totalItems - Number of Total Items
     * @return Instance of Class
     */
    public DBResult<X> setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        return this;
    } 

    /**
     * Get Items
     * @return List of Items
     */
    public List<X> getItems() {
        return items;
    }

    /**
     * Set Items
     * @param items - List of Items 
     * @return Instance of Class
     */
    public DBResult<X> setItems(List<X> items) {
        this.items = items;
        return this;
    }

}
