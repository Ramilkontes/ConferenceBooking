package com.local.conferencebooking.security.details;

import com.local.conferencebooking.exceptions.UsersNotFountException;
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
    public UserDetails loadUserByUsername(String login) throws UsersNotFountException {
        return new UserDetailsImpl(repositories.findOneByLogin(login).orElseThrow(UsersNotFountException::new));
    }
}
