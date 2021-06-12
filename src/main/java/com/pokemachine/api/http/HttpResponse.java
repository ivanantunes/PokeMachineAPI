package com.pokemachine.api.http;

/**
 * Class contains the http response codes.
 * @author ivanantunes
 */
public class HttpResponse {
    
    /**
     * Http Response - OK
     */
    public static int OK = 200;

    /**
     * Http Response - Internal Server Error
     */
    public static int INTERNAL_SERVER_ERROR = 500;

    /**
     * Http Response - Not Found
     */
    public static int NOT_FOUND = 404;

    /**
     * Http Response - Bad Request
     */
    public static int BAD_REQUEST = 400;
    
    /**
     * Http Response - Unauthorized
     */
    public static int UNAUTHORIZED = 401;

    /**
     * Constructor
     */
    private HttpResponse() { }

}
