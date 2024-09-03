package org.restaurante.msusuarios.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.msusuarios.application.dto.response.EmployeeResponseDto;
import org.restaurante.msusuarios.domain.model.UserModel;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeResponseMapper {

    EmployeeResponseDto toEmployeeResponseDto(UserModel userModel);
}
