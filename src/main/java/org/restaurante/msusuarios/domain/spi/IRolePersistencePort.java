package org.restaurante.msusuarios.domain.spi;

import org.restaurante.msusuarios.domain.model.RoleModel;

import java.util.List;

public interface IRolePersistencePort {

    List<RoleModel> getAllRoles();

    RoleModel getRole(String rolName);
}
