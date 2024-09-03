package org.restaurante.msusuarios.domain.usecase;

import org.restaurante.msusuarios.domain.api.IClientServicePort;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;

public class ClientUseCase implements IClientServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IPasswordEncodedServicePort passwordEncodedServicePort;

    public ClientUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IPasswordEncodedServicePort passwordEncodedServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.passwordEncodedServicePort = passwordEncodedServicePort;
    }

    @Override
    public void saveClient(UserModel userModel) {
        userModel.setRoleId(rolePersistencePort.getRole("CLIENT").getId());
        userModel.setPassword(passwordEncodedServicePort.encryptPassword(userModel.getPassword()));

        userPersistencePort.createUser(userModel);
    }

    @Override
    public UserModel getClient(Long userId) {
        return userPersistencePort.getUser(userId, rolePersistencePort.getRole("CLIENT").getId());
    }
}
