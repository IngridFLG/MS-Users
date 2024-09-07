package org.restaurante.msusuarios.domain.api;

import org.restaurante.msusuarios.domain.model.UserModel;

public interface IAdminServicePort {

    void saveOwner(UserModel user);

    UserModel getOwner(Long id);
}
