package com.getir.bookstore.common.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    public static String ANONYMOUS_USER = "anonymousUser";

    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO SECURITY
        return Optional.of(ANONYMOUS_USER);
    }
}
