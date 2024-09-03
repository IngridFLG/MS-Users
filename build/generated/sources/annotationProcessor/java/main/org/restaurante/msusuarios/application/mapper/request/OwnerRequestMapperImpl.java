package org.restaurante.msusuarios.application.mapper.request;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.request.OwnerRequestDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OwnerRequestMapperImpl implements OwnerRequestMapper {

    @Override
    public UserModel toUserModel(OwnerRequestDto ownerRequestDto) {
        if ( ownerRequestDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setName( ownerRequestDto.getName() );
        userModel.setLastname( ownerRequestDto.getLastname() );
        userModel.setDni( ownerRequestDto.getDni() );
        userModel.setEmail( ownerRequestDto.getEmail() );
        userModel.setPassword( ownerRequestDto.getPassword() );
        userModel.setPhone( ownerRequestDto.getPhone() );
        userModel.setDateOfBirth( ownerRequestDto.getDateOfBirth() );

        return userModel;
    }
}
