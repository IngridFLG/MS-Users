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
class ClientUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @Mock
    private IPasswordEncodedServicePort passwordEncodedServicePort;

    @InjectMocks
    private ClientUseCase clientUseCase;

    @Test
    void saveClient_shouldSaveClientWithEncryptedPasswordAndRole() {
        UserModel user = new UserModel();
        user.setName("Jane");
        user.setLastname("Doe");
        user.setDni(87654321);
        user.setEmail("jane.doe@example.com");
        user.setPassword("password123");
        user.setPhone("+573001234567");

        RoleModel clientRole = new RoleModel(3L, "CLIENT");
        when(rolePersistencePort.getRole("CLIENT")).thenReturn(clientRole);
        when(passwordEncodedServicePort.encryptPassword("password123")).thenReturn("encryptedPassword123");

        clientUseCase.saveClient(user);

        assertEquals(clientRole.getId(), user.getRoleId());
        assertEquals("encryptedPassword123", user.getPassword());

        verify(userPersistencePort).createUser(user);
    }

    @Test
    void getClient_shouldReturnClient() {
        Long userId = 1L;

        RoleModel clientRole = new RoleModel(3L, "CLIENT");

        UserModel user = new UserModel(userId, "Jane", "Doe", 87654321, "jane.doe@example.com", "encryptedPassword123", null, "+573001234567", null, clientRole.getId());

        when(rolePersistencePort.getRole("CLIENT")).thenReturn(clientRole);
        when(userPersistencePort.getUser(userId, clientRole.getId())).thenReturn(user);

        UserModel result = clientUseCase.getClient(userId);

        assertEquals(user, result);
    }
}
