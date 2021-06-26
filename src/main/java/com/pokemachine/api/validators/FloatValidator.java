package com.pokemachine.api.validators;

/**
 * Float Validator
 * @author gbrextreme
 */
public class FloatValidator {
    
    /**
     * Constructor
     */
    private FloatValidator() { }

    /**
     * Check value is smaller then a number
     * @param value - Value
     * @param size - Size to validate
     * @param label - Label Message
     * @return Message
     */
    public static String isSmaller(float value, float size, String label) {
        if (size > value) {
            return label + " é menor que " + size;
        }
        return "";
    } 

    /**
     * Check value is bigger then a number
     * @param value - Value 
     * @param size - Size to validate
     * @param label - Label Message
     * @return Message
     */
    public static String isBigger(float value, float size, String label) {
        if (size < value) {
            return label + " é maior que " + size;
        }
        return "";
    }

    /**
     * Check value is between a number
     * @param value - Value
     * @param min - Min size of value
     * @param max - Max size of value
     * @param label - Label message
     * @return Message
     */
    public static String isBetween(float value, float min, float max, String label) {
        if (value < min && value > max) {
            return label + "valor tem que estar entre " + min + " e " + max;
        }
        return "";
    }



}
