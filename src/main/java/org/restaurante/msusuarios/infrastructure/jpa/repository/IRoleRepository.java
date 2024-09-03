package org.restaurante.msusuarios.infrastructure.jpa.repository;

import org.restaurante.msusuarios.infrastructure.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findRoleEntityByName(String name);
}
