package com.getir.bookstore.core.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    public static final String BAD_CREDENTIALS = "bad.credentials";

    private final CustomUserDetailService customUserDetailService;

    public CustomAuthenticationManager(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) {

        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        CustomUserDetail userDetails = customUserDetailService.loadUserByUsername(email);

        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(BAD_CREDENTIALS);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException(BAD_CREDENTIALS);
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

    }
}
