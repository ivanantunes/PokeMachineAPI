package com.pokemachine.api.http;

/**
 * Class contains a simple http message
 * @author ivanantunes
 */
public class HttpMessage {
    
    /**
     * Http Code
     */
    private int code;

    /**
     * Http Error Message
     */
    private String error = "";

    /**
     * Http Simple Message
     */
    private String message = "";

    /**
     * Http Object Result
     */
    private Object result = null;

    /**
     * Constructor
     */
    private HttpMessage() { }

    /**
     * Build Class
     * @return New Instance of HttpMessage
     */
    public static HttpMessage build() {
        return new HttpMessage();
    }

    /**
     * Get Code
     * @return Code of Http Message
     */
    public int getCode() {
        return code;
    }

    /**
     * Set Code
     * @param code - Code of Http Message
     * @return Instance of HttpMessage
     */
    public HttpMessage setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * Get Error
     * @return Error of Http Messge
     */
    public String getError() {
        return error;
    }

    /**
     * Set Error
     * @param error - Http Error
     * @return Instance of HttpMessage
     */
    public HttpMessage setError(String error) {
        this.error = error;
        return this;
    }

    /**
     * Get Message
     * @return Message of Http Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message
     * @param message - Message of Http Message
     * @return Instance of HttpMessage
     */
    public HttpMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get 
     * @return Object of Http Message
     */
    public Object getResult() {
        return result;
    }

    /**
     * Set Result
     * @param result - Object of Http Message
     * @return Instance of HttpMessage
     */
    public HttpMessage setResult(Object result) {
        this.result = result;
        return this;
    }

}
