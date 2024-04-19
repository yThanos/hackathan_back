package br.hackathan.com.hackathan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    private final AuthFilter authFilter;
    private final DdosFilter ddosFilter;

    public SecurityConfig(CustomUserDetailsService userDetailsService, AuthFilter authFilter, DdosFilter ddosFilter) {
        this.userDetailsService = userDetailsService;
        this.authFilter = authFilter;
        this.ddosFilter = ddosFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
        return authBuilder.build();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(this.authFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(this.ddosFilter, DisableEncodeUrlFilter.class);
        http.cors(cors->cors.configurationSource(corsConfig->{
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("http://localhost:3000");
            corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
            corsConfiguration.addAllowedMethod(HttpMethod.GET);
            corsConfiguration.addAllowedMethod(HttpMethod.POST);
            corsConfiguration.addAllowedMethod(HttpMethod.PUT);
            corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
            corsConfiguration.addAllowedHeader("Authorization");
            corsConfiguration.addAllowedHeader("Content-Type");
            return corsConfiguration;
        })).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize->authorize.anyRequest().permitAll()
                ///.requestMatchers("/auth/**").permitAll()
                //.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                //.anyRequest().authenticated()
        ).csrf(csrf->csrf.disable());
        return http.build();
    }
}
