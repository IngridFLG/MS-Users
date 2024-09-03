package org.restaurante.msusuarios.infrastructure.jpa.adapter;


import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;
import org.restaurante.msusuarios.infrastructure.jpa.entity.UserEntity;
import org.restaurante.msusuarios.infrastructure.jpa.exception.ExistsEmailException;
import org.restaurante.msusuarios.infrastructure.jpa.exception.ExistsUserException;
import org.restaurante.msusuarios.infrastructure.jpa.exception.UserNotFoundException;
import org.restaurante.msusuarios.infrastructure.jpa.mapper.UserEntityMapper;
import org.restaurante.msusuarios.infrastructure.jpa.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static org.restaurante.msusuarios.infrastructure.configuration.Constants.EMPLOYEE_ROLE_ID;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort{

    private final UserEntityMapper userEntityMapper;

    private final IUserRepository userRepository;

    @Override
    public void createUser(UserModel user) {
        if(userRepository.findUserEntityByEmail(user.getEmail()).isPresent()) {
            throw new ExistsEmailException();
        }

        if(userRepository.findUserEntityByDni(user.getDni()).isPresent()) {
            throw new ExistsUserException();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public UserModel getUser(Long id, Long roleId) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByIdAndRoleId(id, roleId);
        if(userEntityOptional.isEmpty()) {
            throw new UserNotFoundException("The user " + id + " does not exist");
        }
        return userEntityMapper.toUserModel(userEntityOptional.get());
    }

    @Override
    public UserModel getEmployee(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmailAndRoleId(email, EMPLOYEE_ROLE_ID);
        if(userEntityOptional.isEmpty()) {
            throw new UserNotFoundException("The employee doesn't exist");
        }

        return userEntityMapper.toUserModel(userEntityOptional.get());
    }

}
