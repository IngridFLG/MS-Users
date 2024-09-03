package org.restaurante.msusuarios.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OwnerUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @Mock
    private IPasswordEncodedServicePort passwordEncodedServicePort;

    @InjectMocks
    private OwnerUseCase ownerUseCase;

    @Test
    void saveEmployee_shouldSaveEmployeeWithEncryptedPasswordAndRole() {
        UserModel user = new UserModel();
        user.setName("Alice");
        user.setLastname("Smith");
        user.setDni(23456789);
        user.setEmail("alice.smith@example.com");
        user.setPassword("password123");
        user.setPhone("+573001234567");

        RoleModel employeeRole = new RoleModel(3L, "EMPLOYEE");
        when(rolePersistencePort.getRole("EMPLOYEE")).thenReturn(employeeRole);
        when(passwordEncodedServicePort.encryptPassword("password123")).thenReturn("encryptedPassword123");

        ownerUseCase.saveEmployee(user);

        assertEquals(employeeRole.getId(), user.getRoleId());
        assertEquals("encryptedPassword123", user.getPassword());

        verify(userPersistencePort).createUser(user);
    }

    @Test
    void getEmployee_shouldReturnEmployee() {
        String email = "alice.smith@example.com";

        UserModel user = new UserModel(1L, "Alice", "Smith", 23456789, email, "encryptedPassword123", null, "+573001234567", null, 3L);
        
        when(userPersistencePort.getEmployee(email)).thenReturn(user);

        UserModel result = ownerUseCase.getEmployee(email);

        assertEquals(user, result);
    }
}
