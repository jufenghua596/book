package com.java7book.chapter13.auth;

import java.security.Principal;

public class UserPrincipal implements Principal {
    private final String username;
    public UserPrincipal(String username) {
        this.username = username;
    }
    public String getName() {
        return username;
    }
}
