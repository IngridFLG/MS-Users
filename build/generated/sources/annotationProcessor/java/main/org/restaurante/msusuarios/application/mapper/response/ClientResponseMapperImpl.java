package org.restaurante.msusuarios.application.mapper.response;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.response.ClientResponseDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClientResponseMapperImpl implements ClientResponseMapper {

    @Override
    public ClientResponseDto toClientResponseDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        ClientResponseDto clientResponseDto = new ClientResponseDto();

        clientResponseDto.setName( userModel.getName() );
        clientResponseDto.setPhone( userModel.getPhone() );

        return clientResponseDto;
    }
}
