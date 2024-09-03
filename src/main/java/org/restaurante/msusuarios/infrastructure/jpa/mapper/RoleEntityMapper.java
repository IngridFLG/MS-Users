package org.restaurante.msusuarios.infrastructure.jpa.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.infrastructure.jpa.entity.RoleEntity;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {

    RoleModel toRoleModel(RoleEntity roleEntity);

    List<RoleModel> toRoleList(List<RoleEntity> roleEntityList);
}
