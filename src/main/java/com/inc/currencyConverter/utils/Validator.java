package com.inc.currencyConverter.utils;

public class Validator {

    public static void validateInputParams(String from, String to, String quantity){
        try {
            validateStringExists(from, "from");
            validateStringExists(to, "to");
            validateStringExists(quantity, "quantity");
            validateStringAsAPositiveNumber(quantity, "quantity");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Currency conversion request is invalid:\n" + e.getLocalizedMessage(), e);
        }
    }

    public static void validateStringExists(String string, String fieldName){
        if(string == null || string.isEmpty()){
            throw new IllegalArgumentException(fieldName + " doesn't exist");
        }
    }

    public static void validateStringAsAPositiveNumber(String num, String fieldName){
        try {
            Double.parseDouble(num);
        }catch (Exception e){
            throw new IllegalArgumentException(fieldName + " " + e.getLocalizedMessage(), e);
        }
    }
}
