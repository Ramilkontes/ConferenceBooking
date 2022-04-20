package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.UsersNotFountException;
import com.local.conferencebooking.forms.LoginForm;
import com.local.conferencebooking.models.Token;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.TokenRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.TokenDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.local.conferencebooking.transfer.TokenDto.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private TokenRepositories repositories;

    @Override
    public TokenDto login(LoginForm form) {
        Optional<User> userCandidate = userRepositories.findOneByLogin(form.getLogin());
        if (userCandidate.isPresent()){
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())){
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();
                repositories.save(token);
                return from(token);
            }
        }
        throw new UsersNotFountException("Пользователь не найден");
    }
}
