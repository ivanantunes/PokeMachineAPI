package com.pokemachine.api.validators;

/**
 * String Validator
 * @author ivanantunes
 */
public class StringValidator {
    
    /**
     * Constructor
     */
    private StringValidator() { }


    /**
     * Check String is Empty
     * @param str - String Validate
     * @param label - Label Message
     * @return Message
     */
    public static String isEmpty(String str, String label) {
        if (str.isEmpty() || str.equals(null)) {
            return label + " é Obrigátorio.";
        }

        return "";
    }

    /**
     * Check String Max Length
     * @param str  String Validate
     * @param label - Label Message
     * @param maxLength - Max Length
     * @return Message
     */
    public static String isMaxLength(String str, String label, int maxLength) {
        if (str.length() > maxLength) {
            return label + " Deve Conter no Máximo " + maxLength + " Caracters.";
        }

        return "";
    }

    /**
     * Check String Min Length
     * @param str  String Validate
     * @param label - Label Message
     * @param minLength - Min Length
     * @return Message
     */
    public static String isMinLength(String str, String label, int minLength) {
        if (str.length() < minLength) {
            return label + " Deve Conter no Minímo " + minLength + " Caracters.";
        }

        return "";
    }

    /**
     * Check String is Valid
     * @param str - String Validate
     * @param label - Label Message
     * @param maxLength - Max Length
     * @param minLength - Min Length
     * @return Message
     */
    public static String isValidSting(String str, String label, int maxLength, int minLength) {

        String message = "";

        message = StringValidator.isEmpty(str, label);

        if (!message.isEmpty()) {
            return message;
        }

        message = StringValidator.isMinLength(str, label, minLength);

        if (!message.isEmpty()) {
            return message;
        }

        message = StringValidator.isMaxLength(str, label, maxLength);

        if (!message.isEmpty()) {
            return message;
        }
        
        return message;
    }
}
