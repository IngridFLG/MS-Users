package org.restaurante.msusuarios.application.util;

public class Constants {

    public Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String EMAIL_REQUIRED = "The email is required";
    public static final String PASSWORD_REQUIRED = "The password is required";
    public static final String NAME_REQUIRED = "The name is required";
    public static final String LAST_NAME_REQUIRED = "The lastname is required";
    public static final String PHONE_REQUIRED = "The phone is required";
    public static final String EMAIL_VALID = "The email is not valid";
    public static final String PHONE_VALIDATION = "^\\+?57\\s?(3[0-2]|7[0-1])\\d{8}$";
    public static final String PHONE_VALIDATION_MESSAGE = "The number phone is not valid";

}
