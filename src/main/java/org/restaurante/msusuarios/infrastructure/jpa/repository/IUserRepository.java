package org.restaurante.msusuarios.infrastructure.jpa.repository;

import java.util.Optional;

import org.restaurante.msusuarios.infrastructure.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{
    
    Optional<UserEntity> findUserEntityByEmail(String email);

    Optional<UserEntity> findUserEntityByDni(Integer dni);

    Optional<UserEntity> findUserEntityByIdAndRoleId(Long id, Long role);

    Optional<UserEntity> findUserEntityByEmailAndRoleId(String email, Long role);
}
