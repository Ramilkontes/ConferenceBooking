package com.local.conferencebooking.security.filters;

import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.security.provider.TokenAuthenticationProvider;
import com.local.conferencebooking.security.token.TokenAuthentication;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthFilter implements Filter {

    private TokenAuthenticationProvider provider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("token");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if (token == null)
            token = request.getParameter("token");
        if (token == null) {
            tokenAuthentication.setAuthenticated(false);
        } else {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
