package org.restaurante.msusuarios.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RoleUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private RoleUseCase roleUseCase;

    @Test
    void getRole() {
        RoleModel roleModel = new RoleModel(1L, "ADMIN");
        when(rolePersistencePort.getRole("ADMIN")).thenReturn(roleModel);

        RoleModel result = roleUseCase.getRole("ADMIN");
        assertEquals(roleModel, result);
    }

    @Test
    void getRole_whenRoleDoesNotExist() {
        when(rolePersistencePort.getRole("UNKNOWN")).thenReturn(null);

        RoleModel result = roleUseCase.getRole("UNKNOWN");
        assertNull(result);
    }

    @Test
    void getAllRoles() {
        List<RoleModel> roles = Arrays.asList(
                new RoleModel(1L, "ADMIN"),
                new RoleModel(2L, "OWNER"),
                new RoleModel(3L, "CLIENT"),
                new RoleModel(4L, "EMPLOYEE")
        );
        when(rolePersistencePort.getAllRoles()).thenReturn(roles);

        List<RoleModel> result = roleUseCase.getAllRoles();
        assertEquals(roles, result);
    }
}
