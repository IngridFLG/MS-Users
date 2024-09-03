package org.restaurante.msusuarios.infrastructure.configuration;

import org.restaurante.msusuarios.domain.api.IAdminServicePort;
import org.restaurante.msusuarios.domain.api.IClientServicePort;
import org.restaurante.msusuarios.domain.api.IOwnerServicePort;
import org.restaurante.msusuarios.domain.api.IPasswordEncodedServicePort;
import org.restaurante.msusuarios.domain.spi.IRolePersistencePort;
import org.restaurante.msusuarios.domain.spi.IUserPersistencePort;
import org.restaurante.msusuarios.domain.usecase.AdminUseCase;
import org.restaurante.msusuarios.domain.usecase.ClientUseCase;
import org.restaurante.msusuarios.domain.usecase.OwnerUseCase;
import org.restaurante.msusuarios.infrastructure.jpa.adapter.RoleJpaAdapter;
import org.restaurante.msusuarios.infrastructure.jpa.adapter.UserJpaAdapter;
import org.restaurante.msusuarios.infrastructure.jpa.mapper.RoleEntityMapper;
import org.restaurante.msusuarios.infrastructure.jpa.mapper.UserEntityMapper;
import org.restaurante.msusuarios.infrastructure.jpa.repository.IRoleRepository;
import org.restaurante.msusuarios.infrastructure.jpa.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    
    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IPasswordEncodedServicePort authPasswordEncoderPort() {
        return new AuthBcryptAdapter(encoder());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userEntityMapper, userRepository);
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleEntityMapper, roleRepository);
    }

     @Bean
     public IAdminServicePort adminServicePort() {
         return new AdminUseCase(userPersistencePort(), rolePersistencePort(), authPasswordEncoderPort());
     }

    @Bean
    public IOwnerServicePort ownerServicePort() {
        return new OwnerUseCase(userPersistencePort(), rolePersistencePort(), authPasswordEncoderPort());
    }

    @Bean
    public IClientServicePort clientServicePort() {
        return new ClientUseCase(userPersistencePort(), rolePersistencePort(), authPasswordEncoderPort());
    }


}
