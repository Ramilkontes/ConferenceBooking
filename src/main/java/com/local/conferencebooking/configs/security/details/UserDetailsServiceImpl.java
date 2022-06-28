package com.local.conferencebooking.configs.security.details;

import com.local.conferencebooking.exceptions.UsersNotFoundException;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositories repositories;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsersNotFoundException {
        return new
                UserDetailsImpl(repositories.findOneByLogin(login)
                .orElseThrow(IllegalArgumentException::new));
    }
}
