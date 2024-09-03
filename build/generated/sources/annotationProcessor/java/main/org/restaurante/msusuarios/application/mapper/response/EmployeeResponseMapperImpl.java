package org.restaurante.msusuarios.application.mapper.response;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.response.EmployeeResponseDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class EmployeeResponseMapperImpl implements EmployeeResponseMapper {

    @Override
    public EmployeeResponseDto toEmployeeResponseDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId( userModel.getId() );
        employeeResponseDto.setName( userModel.getName() );
        employeeResponseDto.setLastname( userModel.getLastname() );
        employeeResponseDto.setDni( userModel.getDni() );
        employeeResponseDto.setEmail( userModel.getEmail() );
        employeeResponseDto.setPhone( userModel.getPhone() );
        employeeResponseDto.setRoleId( userModel.getRoleId() );

        return employeeResponseDto;
    }
}
