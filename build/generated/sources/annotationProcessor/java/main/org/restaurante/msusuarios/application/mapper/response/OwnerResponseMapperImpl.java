package org.restaurante.msusuarios.application.mapper.response;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.response.OwnerResponseDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class OwnerResponseMapperImpl implements OwnerResponseMapper {

    @Override
    public OwnerResponseDto toOwnerResponseDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        OwnerResponseDto ownerResponseDto = new OwnerResponseDto();

        ownerResponseDto.setId( userModel.getId() );
        ownerResponseDto.setName( userModel.getName() );
        ownerResponseDto.setLastname( userModel.getLastname() );
        ownerResponseDto.setDni( userModel.getDni() );
        ownerResponseDto.setEmail( userModel.getEmail() );
        ownerResponseDto.setPhone( userModel.getPhone() );
        ownerResponseDto.setRoleId( userModel.getRoleId() );

        return ownerResponseDto;
    }
}
