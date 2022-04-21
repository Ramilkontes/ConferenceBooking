package com.local.conferencebooking.security.provider;

import com.local.conferencebooking.models.Token;
import com.local.conferencebooking.repositories.TokenRepositories;
import com.local.conferencebooking.security.details.UserDetailsServiceImpl;
import com.local.conferencebooking.security.token.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider, AuthenticationManager {

    @Autowired
    private TokenRepositories tokenRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        Optional<Token> tokenCandidate = tokenRepository.findOneByValue(tokenAuthentication.getName());
        if (tokenCandidate.isPresent()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getUser().getLogin());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else throw new IllegalArgumentException("bad token");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
