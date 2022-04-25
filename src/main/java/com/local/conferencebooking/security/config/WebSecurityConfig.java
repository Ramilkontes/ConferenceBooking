package com.local.conferencebooking.security.config;

import com.local.conferencebooking.security.filters.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@ComponentScan("com.local")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/meet-room").permitAll()
                .antMatchers("/meet-room/**").hasAuthority("ADMIN")
                .antMatchers("/users/**").fullyAuthenticated()
                .antMatchers("/events/**").authenticated()
                .antMatchers("/login").permitAll();
        http.csrf().disable();
    }
}
