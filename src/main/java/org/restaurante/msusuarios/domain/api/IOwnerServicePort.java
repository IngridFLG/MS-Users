package org.restaurante.msusuarios.domain.api;

import org.restaurante.msusuarios.domain.model.UserModel;

public interface IOwnerServicePort {

    void saveEmployee(UserModel user);

    UserModel getEmployee(String email);

}
