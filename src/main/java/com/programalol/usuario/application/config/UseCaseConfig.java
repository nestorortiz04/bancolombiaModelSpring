package com.programalol.usuario.application.config;

import com.programalol.usuario.domain.model.gateways.IUsuarioGateway;
import com.programalol.usuario.domain.usecase.UsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Se le delega la config. y la isntancia a esta clase q esta en la capa de aplica..
@Configuration
public class UseCaseConfig {
    @Bean
    public UsuarioUseCase usuarioUseCase(IUsuarioGateway usuarioGateway){
        return new UsuarioUseCase(usuarioGateway);
    };
}
