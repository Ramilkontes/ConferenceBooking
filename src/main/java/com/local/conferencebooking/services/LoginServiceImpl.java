package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.LoginForm;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepositories repositories;

    @Override
    public Object login(LoginForm form) {
        return null;
    }
}
