package com.fiec.estoqueback.features.user.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserLevel implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_GUEST;

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}