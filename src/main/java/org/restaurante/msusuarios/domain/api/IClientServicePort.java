package org.restaurante.msusuarios.domain.api;

import org.restaurante.msusuarios.domain.model.UserModel;

public interface IClientServicePort {

    void saveClient(UserModel userModel);

    UserModel getClient(Long userId);
}
