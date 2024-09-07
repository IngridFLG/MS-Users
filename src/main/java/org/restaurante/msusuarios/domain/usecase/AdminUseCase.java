package org.restaurante.msusuarios.domain.usecase;
import org.restaurante.msusuarios.domain.api.IAdminServicePort;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.exceptions.IsOlderUserException;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;
import org.restaurante.msusuarios.domain.validate.UserValidate;

import static org.restaurante.msusuarios.domain.util.Constants.OWNER;


public class AdminUseCase implements IAdminServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IPasswordEncodedServicePort passwordEncodedServicePort;

    public AdminUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IPasswordEncodedServicePort passwordEncodedServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.passwordEncodedServicePort = passwordEncodedServicePort;
    }

    @Override
    public void saveOwner(UserModel user) {
        if (!UserValidate.isOlder(user)) {
            throw new IsOlderUserException();
        }

        user.setRoleId(rolePersistencePort.getRole(OWNER).getId());
        user.setPassword(passwordEncodedServicePort.encryptPassword(user.getPassword()));

        userPersistencePort.createUser(user);
    }

    @Override
    public UserModel getOwner(Long id) {
        return userPersistencePort.getUser(id, rolePersistencePort.getRole(OWNER).getId());
    }
}
