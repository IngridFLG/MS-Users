package org.restaurante.msusuarios.domain.spi;

import org.restaurante.msusuarios.domain.model.UserModel;

public interface IUserPersistencePort {

    void createUser(UserModel user);

    UserModel getUser(Long id, Long roleId);

    UserModel getEmployee(String email);

}
