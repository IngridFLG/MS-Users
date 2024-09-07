package org.restaurante.msusuarios.domain.validate;

import org.restaurante.msusuarios.domain.model.UserModel;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.restaurante.msusuarios.domain.util.Constants.MIN_VALUE_AGE;

public class UserValidate {

    public static boolean isOlder(UserModel user) {
        Date dateOfBirth = user.getDateOfBirth();
        try {
            LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate now = LocalDate.now();
            Period period = Period.between(birthDate, now);
            int age = period.getYears();
            return age >= MIN_VALUE_AGE;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
