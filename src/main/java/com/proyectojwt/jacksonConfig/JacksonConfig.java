package com.proyectojwt.jacksonConfig;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.proyectojwt.entity.Authority;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(){
        return builder -> builder.modules(new SimpleModule().addAbstractTypeMapping(GrantedAuthority.class, Authority.class));
    }
}
