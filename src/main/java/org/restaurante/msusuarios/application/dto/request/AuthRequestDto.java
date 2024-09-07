package org.restaurante.msusuarios.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import static org.restaurante.msusuarios.application.util.Constants.EMAIL_REQUIRED;
import static org.restaurante.msusuarios.application.util.Constants.PASSWORD_REQUIRED;

@Getter
@Setter
public class AuthRequestDto {

    @NotBlank(message = EMAIL_REQUIRED)
    private String email;

    @NotBlank(message = PASSWORD_REQUIRED)
    private String password;
}
