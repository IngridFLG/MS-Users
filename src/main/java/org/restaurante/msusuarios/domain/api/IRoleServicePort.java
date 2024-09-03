package org.restaurante.msusuarios.domain.api;

import org.restaurante.msusuarios.domain.model.RoleModel;

import java.util.List;

public interface IRoleServicePort {

    List<RoleModel> getAllRoles();

    RoleModel getRole(String rolName);
}
