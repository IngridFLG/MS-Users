package org.restaurante.msusuarios.application.handler.interfaces;

import org.restaurante.msusuarios.application.dto.request.OwnerRequestDto;
import org.restaurante.msusuarios.application.dto.response.OwnerResponseDto;

public interface IAdminHandler {
    void saveOwner(OwnerRequestDto ownerRequestDto);

    OwnerResponseDto getOwner(Long id);
}
