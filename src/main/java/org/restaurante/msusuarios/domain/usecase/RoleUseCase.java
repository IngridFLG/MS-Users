package org.restaurante.msusuarios.domain.usecase;

import org.restaurante.msusuarios.domain.api.IRoleServicePort;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort persistencePort;


    public RoleUseCase(IRolePersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }


    @Override
    public List<RoleModel> getAllRoles() {
        return persistencePort.getAllRoles();
    }

    @Override
    public RoleModel getRole(String rolName) {
        return persistencePort.getRole(rolName);
    }
}
