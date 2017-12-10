package com.java7book.securewebapp.login;

import java.io.Serializable;
import java.security.Principal;

public class UserPrincipal implements Principal, Serializable {
    private final String username;
    public UserPrincipal(String username) {
        this.username = username;
    }
    public String getName() {
        return username;
    }
}
