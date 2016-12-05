package com.bookzilla.security;


import com.bookzilla.model.User;
import com.bookzilla.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;

/**
 * Created by adinu on 12/3/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    public void grantUser(User user) throws Exception {

        authenticationManagerBuilder.inMemoryAuthentication().withUser(user.getUsername())
                .password(user.getPassword()).roles("USER");
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {

        List<User> registeredUsers = userService.listAllUsers();

        for (User user : registeredUsers) {
            auth.inMemoryAuthentication().withUser(user.getUsername())
                    .password(user.getPassword()).roles("USER");
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable().exceptionHandling()
                .and()
            .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .antMatchers("/*").access("hasRole('USER')")
                .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/", true)
                .usernameParameter("username").passwordParameter("password");
    }
}

