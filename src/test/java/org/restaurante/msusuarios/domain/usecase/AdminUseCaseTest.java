package org.restaurante.msusuarios.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.exceptions.IsOlderUserException;
import org.restaurante.msusuarios.domain.model.RoleModel;
import org.restaurante.msusuarios.domain.model.UserModel;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;

import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AdminUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @Mock
    private IPasswordEncodedServicePort passwordEncodedServicePort;

    @InjectMocks
    private AdminUseCase adminUseCase;

    @Test
    void saveOwner_whenUserIsOlder_shouldSaveUser() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -30);
        Date dateOfBirth = cal.getTime();

        UserModel user = new UserModel(null, "John", "Doe", 12345678, "john.doe@example.com", "password123", null, "+573001234567", dateOfBirth, null);
        RoleModel ownerRole = new RoleModel(2L, "OWNER");

        when(rolePersistencePort.getRole("OWNER")).thenReturn(ownerRole);
        when(passwordEncodedServicePort.encryptPassword("password123")).thenReturn("encryptedPassword123");

        adminUseCase.saveOwner(user);

        assertEquals(ownerRole.getId(), user.getRoleId());
        assertEquals("encryptedPassword123", user.getPassword());
        verify(userPersistencePort).createUser(user);
    }

    @Test
    void saveOwner_whenUserIsYounger_shouldThrowException() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -17);
        Date dateOfBirth = cal.getTime();

        UserModel user = new UserModel(null, "John", "Doe", 12345678, "john.doe@example.com", "password123", null, "+573001234567", dateOfBirth, null);

        assertThrows(IsOlderUserException.class, () -> adminUseCase.saveOwner(user));

        verify(userPersistencePort, never()).createUser(any(UserModel.class));
    }

    @Test
    void getOwner_shouldReturnOwner() {
        Long userId = 1L;
        RoleModel ownerRole = new RoleModel(2L, "OWNER");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -30); // Usuario de 30 años
        Date dateOfBirth = cal.getTime();
        UserModel user = new UserModel(userId, "John", "Doe", 12345678, "john.doe@example.com", "encryptedPassword123", null, "+573001234567", dateOfBirth, ownerRole.getId());

        when(rolePersistencePort.getRole("OWNER")).thenReturn(ownerRole);
        when(userPersistencePort.getUser(userId, ownerRole.getId())).thenReturn(user);

        UserModel result = adminUseCase.getOwner(userId);

        assertEquals(user, result);
    }
}
