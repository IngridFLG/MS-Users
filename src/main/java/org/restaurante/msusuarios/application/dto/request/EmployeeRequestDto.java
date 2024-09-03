package org.restaurante.msusuarios.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The lastname is required")
    private String lastname;

    @NotNull
    private Integer dni;

    @Email(message = "The email is not valid")
    private String email;

    @NotBlank(message = "The password is required")
    private String password;

    @NotBlank
    @Pattern(regexp = "^\\+?57\\s?(3[0-2]|7[0-1])\\d{8}$", message = "The number phone is not valid")
    private String phone;

}
