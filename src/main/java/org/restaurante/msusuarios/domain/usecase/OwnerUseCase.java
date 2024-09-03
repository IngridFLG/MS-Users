package org.restaurante.msusuarios.domain.usecase;

import org.restaurante.msusuarios.domain.api.IOwnerServicePort;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;

public class OwnerUseCase implements IOwnerServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IPasswordEncodedServicePort passwordEncodedServicePort;

    public OwnerUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IPasswordEncodedServicePort passwordEncodedServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.passwordEncodedServicePort = passwordEncodedServicePort;
    }

    @Override
    public void saveEmployee(UserModel user) {

        user.setRoleId(rolePersistencePort.getRole("EMPLOYEE").getId());
        user.setPassword(passwordEncodedServicePort.encryptPassword(user.getPassword()));

        userPersistencePort.createUser(user);
    }

    @Override
    public UserModel getEmployee(String email) {
        return userPersistencePort.getEmployee(email);
    }
}
