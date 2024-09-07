package org.restaurante.msusuarios.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static org.restaurante.msusuarios.application.util.Constants.*;

@Getter
@Setter
public class EmployeeRequestDto {

    @NotBlank(message = NAME_REQUIRED)
    private String name;

    @NotBlank(message = LAST_NAME_REQUIRED)
    private String lastname;

    @NotNull
    private Integer dni;

    @Email(message = EMAIL_VALID)
    private String email;

    @NotBlank(message = PASSWORD_REQUIRED)
    private String password;

    @NotBlank
    @Pattern(regexp = PHONE_VALIDATION, message = PHONE_VALIDATION_MESSAGE)
    private String phone;

}
