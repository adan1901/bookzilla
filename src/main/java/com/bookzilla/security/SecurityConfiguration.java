package com.bookzilla.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by adinu on 12/3/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin")
                .roles("USER", "ADMIN");
        auth.inMemoryAuthentication().withUser("test").password("test")
                .roles("USER");
        auth.inMemoryAuthentication().withUser("test").password("1234")
                .roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("1234")
                .roles("USER");
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

