package attestation.attestation01.validation;

import attestation.attestation01.exception.LoginValidationException;
import attestation.attestation01.exception.PasswordValidationException;

import java.util.UUID;
import java.util.regex.Pattern;

public class UserValidation {

    public static String validateId(String id) {
        try {
            return UUID.fromString(id).toString();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Id is not a valid UUID");
        }
    }

    public static String validateLogin(String login) {
       if(Pattern.compile("^(?!\\d{1,20})(\\w{1,20})$").matcher(login).find()) {
           return login;
        } else {
           throw new LoginValidationException("Login is not valid");
       }
    }

    public static String validatePassword(String password) {
        if(Pattern.compile("^(?!\\d{1,20})(\\w{1,20})$").matcher(password).find()) {
            return password;
        } else {
            throw new PasswordValidationException("Password is not valid");
        }
    }

    public static String validateName(String password) {
        if(Pattern.compile("[\\w&&[^\\d]]+$").matcher(password).find()) {
            return password;
        } else {
            throw new IllegalArgumentException("Name is not valid");
        }
    }

    public static String validateLastName(String password) {
        if(Pattern.compile("[\\w&&[^\\d]]*$").matcher(password).find()) {
            return password;
        } else {
            throw new IllegalArgumentException("Password is not valid");
        }
    }

}
