package org.restaurante.msusuarios.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthBcryptAdapter implements IPasswordEncodedServicePort {

    private final PasswordEncoder encoder;

    @Override
    public String encryptPassword(String password) {
        return encoder.encode(password);
    }
}
