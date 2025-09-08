package com.dozenflow.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desabilita a proteção CSRF, que é a causa do erro 403 em APIs stateless
            .csrf(csrf -> csrf.disable())

            // Define as regras de autorização para os endpoints
            .authorizeHttpRequests(auth -> auth
                // Permite acesso sem autenticação a todos os endpoints da API e do Swagger
                .requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                // Qualquer outra requisição deve ser permitida (para o RootController, etc.)
                .anyRequest().permitAll()
            )

            // Aplica a configuração de CORS definida na classe WebConfig
            .cors(withDefaults());

        return http.build();
    }
}
