package org.restaurante.msusuarios.infrastructure.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.infrastructure.jpa.mapper.RoleEntityMapper;
import org.restaurante.msusuarios.infrastructure.jpa.repository.IRoleRepository;

import java.util.List;



@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final RoleEntityMapper roleEntityMapper;

    private final IRoleRepository roleRepository;

    @Override
    public List<RoleModel> getAllRoles() {
        return roleEntityMapper.toRoleList(roleRepository.findAll());
    }

    @Override
    public RoleModel getRole(String rolName) {

        return roleEntityMapper.toRoleModel(roleRepository.findRoleEntityByName(rolName).get());
    }
}
