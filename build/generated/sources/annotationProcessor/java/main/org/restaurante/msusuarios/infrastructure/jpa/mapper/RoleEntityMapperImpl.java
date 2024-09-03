package org.restaurante.msusuarios.infrastructure.jpa.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.infrastructure.jpa.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T10:06:43-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class RoleEntityMapperImpl implements RoleEntityMapper {

    @Override
    public RoleModel toRoleModel(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleModel roleModel = new RoleModel();

        roleModel.setId( roleEntity.getId() );
        roleModel.setName( roleEntity.getName() );

        return roleModel;
    }

    @Override
    public List<RoleModel> toRoleList(List<RoleEntity> roleEntityList) {
        if ( roleEntityList == null ) {
            return null;
        }

        List<RoleModel> list = new ArrayList<RoleModel>( roleEntityList.size() );
        for ( RoleEntity roleEntity : roleEntityList ) {
            list.add( toRoleModel( roleEntity ) );
        }

        return list;
    }
}
