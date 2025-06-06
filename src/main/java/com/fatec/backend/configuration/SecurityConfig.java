package com.fatec.backend.configuration;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserAuthenticationFilter userAuthenticationFilter;

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/users/login",
                                "/swagger-ui",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/api/vehicle/create-vehicle/{userId}",
                                "/api/vehicle/update-vehicle/{id}",
                                "/api/vehicle/delete-vehicle/{id}",
                                "/api/vehicle/listall-vehicle",
                                "/api/vehicle/findbyid-vehicle/{id}",
                                "/api/users/create-user",
                                "/api/users/delete/{id}",
                                "/api/users/update/{id}",
                                "/api/users/listall-users",
                                "/api/fipe/marcas",
                                "/api/fipe/marcas/{marcaId}/modelos",
                                "/api/fipe/marcas/{marcaId}/modelos/{modeloId}/anos",
                                "/api/fipe/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}",
                                "/api/vehicle/fuel-refill/new-fuel-refill/{vehicleId}/{gasStationId}",
                                "/api/vehicle/fuel-refill/update-fuel-refill/{id}",
                                "/api/vehicle/fuel-refill/delete-refill/{id}",
                                "/api/vehicle/fuel-refill/list-all-fuel-refill",
                                "/api/vehicle/fuel-refill/find-by-id-fuel-refill/{id}",
                                "/api/gasstation/create-gas-station",
                                "/api/gasstation/update-gas-station/{id}",
                                "/api/gasstation/delete-gas-station/{id}",
                                "/api/gasstation/findbyid-gas-station/{id}",
                                "/api/gasstation/listall-gas-station"
                        ).permitAll())
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

