package com.abdulkadersafi.mvc_seurity.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  // Hard Codding the uses
  // @Bean
  // public InMemoryUserDetailsManager userDetailsManager() {
  // UserDetails admin = User.builder()
  // .username("admin")
  // .password("{noop}admin")
  // .roles("ADMIN", "MANAGER", "EMPLOYEE")
  // .build();

  // UserDetails manager = User.builder()
  // .username("manager")
  // .password("{noop}manager")
  // .roles("MANAGER", "EMPLOYEE")
  // .build();

  // UserDetails employee = User.builder()
  // .username("employee")
  // .password("{noop}employee")
  // .roles("EMPLOYEE")
  // .build();

  // return new InMemoryUserDetailsManager(admin, manager, employee);
  // }

  // getting user from DB
  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    // get the user and roles from the data base using users and authorities tables
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(conf -> conf
            // Role base routes
            .requestMatchers("/").hasRole("EMPLOYEE")
            .requestMatchers("/leaders/**").hasRole("MANAGER")
            .requestMatchers("/systems/**").hasRole("ADMIN")
            .anyRequest()
            .authenticated())
        .exceptionHandling(conf -> conf
            // Forbidden Request custom page
            .accessDeniedPage("/auth/403"))
        .formLogin(form -> form
            // Custom Login Form
            .loginPage("/auth/login")
            .loginProcessingUrl("/auth/login")
            .permitAll())
        .logout(logout -> logout
            // Logout POST
            .permitAll());

    return http.build();
  }
}
