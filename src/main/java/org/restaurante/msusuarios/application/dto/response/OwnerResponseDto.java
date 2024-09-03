package org.restaurante.msusuarios.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDto {

    private Long id;

    private String name;

    private String lastname;

    private Integer dni;

    private String email;

    private String phone;

    private Long roleId;
}
