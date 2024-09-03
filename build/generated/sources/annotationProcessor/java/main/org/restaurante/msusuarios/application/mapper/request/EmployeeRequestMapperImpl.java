package org.restaurante.msusuarios.application.mapper.request;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.request.EmployeeRequestDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class EmployeeRequestMapperImpl implements EmployeeRequestMapper {

    @Override
    public UserModel toUserModel(EmployeeRequestDto employeeRequestDto) {
        if ( employeeRequestDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setName( employeeRequestDto.getName() );
        userModel.setLastname( employeeRequestDto.getLastname() );
        userModel.setDni( employeeRequestDto.getDni() );
        userModel.setEmail( employeeRequestDto.getEmail() );
        userModel.setPassword( employeeRequestDto.getPassword() );
        userModel.setPhone( employeeRequestDto.getPhone() );

        return userModel;
    }
}
