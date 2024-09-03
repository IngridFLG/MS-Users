package org.restaurante.msusuarios.application.handler;

import org.restaurante.msusuarios.application.dto.request.OwnerRequestDto;
import org.restaurante.msusuarios.application.dto.response.OwnerResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IAdminHandler;
import org.restaurante.msusuarios.application.mapper.request.OwnerRequestMapper;
import org.restaurante.msusuarios.application.mapper.response.OwnerResponseMapper;
import org.restaurante.msusuarios.domain.api.IAdminServicePort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminHandler implements IAdminHandler {

    private final IAdminServicePort adminServicePort;
    private final OwnerRequestMapper ownerRequestMapper;
    private final OwnerResponseMapper ownerResponseMapper;

    @Override
    public void saveOwner(OwnerRequestDto ownerRequestDto) {
        adminServicePort.saveOwner(ownerRequestMapper.toUserModel(ownerRequestDto));
    }

    @Override
    public OwnerResponseDto getOwner(Long id) {
        return ownerResponseMapper.toOwnerResponseDto(adminServicePort.getOwner(id));
    }

}
