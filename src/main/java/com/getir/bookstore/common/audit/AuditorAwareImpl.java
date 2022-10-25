package com.getir.bookstore.common.audit;

import com.getir.bookstore.core.security.CustomUserDetail;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    public static String ANONYMOUS_USER = "anonymousUser";

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (ANONYMOUS_USER.equals(authentication.getPrincipal()) || !authentication.isAuthenticated()) {
            return Optional.of(ANONYMOUS_USER);
        }

        Jwt jwt = (Jwt) authentication.getPrincipal();

        return Optional.of(jwt.getClaims().get("id").toString());

    }
}
