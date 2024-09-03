package org.restaurante.msusuarios.infrastructure.jpa.mapper;

import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.infrastructure.jpa.entity.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserEntity toUserEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setLastname( userModel.getLastname() );
        userEntity.setDni( userModel.getDni() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setToken( userModel.getToken() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setDateOfBirth( userModel.getDateOfBirth() );
        userEntity.setRoleId( userModel.getRoleId() );

        return userEntity;
    }

    @Override
    public UserModel toUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setLastname( userEntity.getLastname() );
        userModel.setDni( userEntity.getDni() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setToken( userEntity.getToken() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setDateOfBirth( userEntity.getDateOfBirth() );
        userModel.setRoleId( userEntity.getRoleId() );

        return userModel;
    }
}
