package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DemoSecurityConfig {
    //add support for JDBC ..... no more hardcode users :-
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id ,pw,active from members where user_id=?");
        // define query to retrieve the authorities/role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
                configuration->
                        configuration
                                .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")


        );

        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery
        //in general, not required for stateless REST APIs that use Post,Get,PUt and DELETE
        http.csrf(csrf->csrf.disable());

        return http.build();

    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails youssef = User.builder()
                .username("youssef")
                .password("{noop}youssef123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mo2men = User.builder()
                .username("mo2men")
                .password("{noop}mo2men123")
                .roles("EMPLOYEE","MANAGER" )
                .build();
        UserDetails ahmed = User.builder()
                .username("ahmed")
                .password("{noop}ahmed123")
                .roles("EMPLOYEE","MANAGER" ,"ADMIN")
                .build();

        return new InMemoryUserDetailsManager(youssef,mo2men,ahmed);
    }

     */
}
