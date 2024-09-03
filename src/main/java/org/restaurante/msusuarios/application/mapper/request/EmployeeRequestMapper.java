package org.restaurante.msusuarios.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.msusuarios.application.dto.request.EmployeeRequestDto;
import org.restaurante.msusuarios.domain.model.UserModel;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeRequestMapper {

    UserModel toUserModel(EmployeeRequestDto employeeRequestDto);
}
