package org.restaurante.msusuarios.application.handler.interfaces;

import org.restaurante.msusuarios.application.dto.request.ClientRequestDto;
import org.restaurante.msusuarios.application.dto.response.ClientResponseDto;

public interface IClientHandler {

    void saveClient(ClientRequestDto clientRequestDto);

    ClientResponseDto getClient(Long userId);
}
