package org.restaurante.msusuarios.application.mapper.request;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.application.dto.request.ClientRequestDto;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClientRequestMapperImpl implements ClientRequestMapper {

    @Override
    public UserModel toUserModel(ClientRequestDto clientRequestDto) {
        if ( clientRequestDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setName( clientRequestDto.getName() );
        userModel.setLastname( clientRequestDto.getLastname() );
        userModel.setDni( clientRequestDto.getDni() );
        userModel.setEmail( clientRequestDto.getEmail() );
        userModel.setPassword( clientRequestDto.getPassword() );
        userModel.setPhone( clientRequestDto.getPhone() );

        return userModel;
    }
}
