package com.flash.config;

import com.flash.security.MyUserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUserPrincipal = (MyUserPrincipal) authentication.getPrincipal();
        return Optional.ofNullable(myUserPrincipal.getId());
    }
}
