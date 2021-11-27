/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author Nguyen Hoan
 */
public class Validate {

    private static final String CODE_REGEX = "^([a-zA-Z]+[\\w]{4,})$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{7,20}$";
    private static final String EMAIL_REGEX = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    private static final String PHONE_NUMBER_REGEX = "^[0-9\\-\\+]{9,11}$";
    private static final String NAME_FORMAT_REGEX = "^[\\p{L}'][ \\p{L}'-]*[\\p{L}]$";

    public static boolean emailFormat(String email) {
        return email.matches(EMAIL_REGEX);
    }
    public static boolean nameFormat(String name){
        return name.matches(NAME_FORMAT_REGEX);
    }
    public static boolean codeFormat(String username) {
        return username.matches(CODE_REGEX);
    }

    public static boolean paswordFormat(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean phoneNumberFormat(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }
    
    
}
