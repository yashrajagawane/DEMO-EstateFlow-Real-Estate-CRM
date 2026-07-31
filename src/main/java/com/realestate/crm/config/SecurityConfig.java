package com.realestate.crm.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration @EnableMethodSecurity
public class SecurityConfig {
    @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/login","/css/**","/js/**","/webjars/**","/error").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/sales/**","/leads/**","/properties/**","/customers/**","/follow-ups/**","/site-visits/**","/bookings/**","/documents/**","/support/**").hasAnyRole("ADMIN","SALES_EXECUTIVE","MANAGER")
            .requestMatchers("/finance/**","/payments/**","/loans/**","/vendors/**","/petty-cash/**","/accounts/**").hasAnyRole("ADMIN","ACCOUNTANT","MANAGER")
            .requestMatchers("/hr/**","/employees/**","/payroll/**").hasAnyRole("ADMIN","HR")
            .anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard", true).failureUrl("/login?error").permitAll())
            .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())
            .csrf(csrf -> csrf.disable())
            .exceptionHandling(ex -> ex.accessDeniedHandler((request,response,exception) -> response.sendRedirect("/access-denied")));
        return http.build();
    }
}
