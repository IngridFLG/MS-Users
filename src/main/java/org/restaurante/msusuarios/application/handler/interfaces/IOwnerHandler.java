package org.restaurante.msusuarios.application.handler.interfaces;

import org.restaurante.msusuarios.application.dto.request.EmployeeRequestDto;
import org.restaurante.msusuarios.application.dto.response.EmployeeResponseDto;

public interface IOwnerHandler {

    void saveEmployee(EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto getEmployee(String email);
}
