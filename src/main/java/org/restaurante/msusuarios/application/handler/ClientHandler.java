package org.restaurante.msusuarios.application.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.application.dto.request.ClientRequestDto;
import org.restaurante.msusuarios.application.dto.response.ClientResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IClientHandler;
import org.restaurante.msusuarios.application.mapper.request.ClientRequestMapper;
import org.restaurante.msusuarios.application.mapper.response.ClientResponseMapper;
import org.restaurante.msusuarios.domain.api.IClientServicePort;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientHandler implements IClientHandler {

    private final IClientServicePort clientServicePort;
    private final ClientRequestMapper clientRequestMapper;
    private final ClientResponseMapper clientResponseMapper;

    @Override
    public void saveClient(ClientRequestDto clientRequestDto) {
        clientServicePort.saveClient(clientRequestMapper.toUserModel(clientRequestDto));
    }

    @Override
    public ClientResponseDto getClient(Long userId) {
        return clientResponseMapper.toClientResponseDto(clientServicePort.getClient(userId));
    }

}
