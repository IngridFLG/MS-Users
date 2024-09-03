package org.restaurante.msusuarios.application.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.application.dto.request.EmployeeRequestDto;
import org.restaurante.msusuarios.application.dto.response.EmployeeResponseDto;
import org.restaurante.msusuarios.application.handler.interfaces.IOwnerHandler;
import org.restaurante.msusuarios.application.mapper.request.EmployeeRequestMapper;
import org.restaurante.msusuarios.application.mapper.response.EmployeeResponseMapper;
import org.restaurante.msusuarios.domain.api.IOwnerServicePort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class OwnerHandler implements IOwnerHandler {

    private final IOwnerServicePort ownerServicePort;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;

    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        ownerServicePort.saveEmployee(employeeRequestMapper.toUserModel(employeeRequestDto));
    }

    @Override
    public EmployeeResponseDto getEmployee(String email) {
        return employeeResponseMapper.toEmployeeResponseDto(ownerServicePort.getEmployee(email));
    }
}
