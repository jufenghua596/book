package com.java7book.chapter13.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class PropertiesFileBasedLoginModule implements LoginModule {
    private CallbackHandler callbackHandler;
    private Subject subject;
    private Properties props = new Properties();
    private boolean authSucceeded = false;
    private String authUsername = null;
    public void initialize(Subject subject, CallbackHandler callbackHandler,
            Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
        String propsFilePath = (String) options.get("properties.file.path");
        File propsFile = new File(propsFilePath);
        try {
            props.load(new FileInputStream(propsFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean login() throws LoginException {
        TextInputCallback usernameInputCallback = new TextInputCallback("用户名： ");
        TextInputCallback passwordInputCallback = new TextInputCallback("密码: ");
        try {
            callbackHandler.handle(new Callback[] {usernameInputCallback, passwordInputCallback});
        } catch (Exception e) {
            throw new LoginException(e.getMessage());
        }
        String username = usernameInputCallback.getText();
        if (username == null || "".equals(username.trim())) {
            throw new AccountException("用户名为空！");
        }
        if (!props.containsKey(username)) {
            throw new AccountNotFoundException("该用户不存在！");
        }
        String password = passwordInputCallback.getText();
        if (password == null || "".equals(password.trim())) {
            throw new CredentialException("密码为空！");
        }
        if (!password.equals(props.get(username))) {
            throw new FailedLoginException("用户名和密码不匹配！");
        }
        authSucceeded = true;
        authUsername = username;
        return true;
    }

    public boolean commit() throws LoginException {
        if (authSucceeded) {
            this.subject.getPrincipals().add(new UserPrincipal(authUsername));
            authUsername = null;
            authSucceeded = false;
            return true;
        }
        return false;
    }

    public boolean abort() throws LoginException {
        authUsername = null;
        if (authSucceeded) {
            authSucceeded = false;
            return true;
        }
        return false;
    }

    public boolean logout() throws LoginException {
        Set<Principal> principals = subject.getPrincipals();
        Set<UserPrincipal> userPrincipals = subject.getPrincipals(UserPrincipal.class);
        for (UserPrincipal principal : userPrincipals) {
            if (principal.getName().equals(authUsername)) {
                principals.remove(principal);
                break;
            }
        }
        return true;
    }
}
