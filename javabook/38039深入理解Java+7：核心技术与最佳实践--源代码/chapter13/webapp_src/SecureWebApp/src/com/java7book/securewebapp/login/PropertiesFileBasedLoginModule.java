package com.java7book.securewebapp.login;

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
import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.java7book.securewebapp.RolePrincipal;

public class PropertiesFileBasedLoginModule implements LoginModule {
    private CallbackHandler callbackHandler;
    private Subject subject;
    private Properties props = new Properties();
    private boolean authSucceeded = false;
    private String authUsername = null;
    private String[] roles = null;
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
    	RequestParameterCallback usernameInputCallback = new RequestParameterCallback("username");
    	RequestParameterCallback passwordInputCallback = new RequestParameterCallback("password");
        try {
            callbackHandler.handle(new Callback[] {usernameInputCallback, passwordInputCallback});
        } catch (Exception e) {
            throw new LoginException(e.getMessage());
        }
        String username = usernameInputCallback.getValue();
        if (username == null || "".equals(username.trim())) {
            throw new AccountException("用户名为空！");
        }
        if (!props.containsKey(username)) {
            throw new AccountNotFoundException("该用户不存在！");
        }
        String password = passwordInputCallback.getValue();
        if (password == null || "".equals(password.trim())) {
            throw new CredentialException("密码为空！");
        }
        String passwordValue = props.getProperty(username);
        String[] parts = passwordValue.split("###");
        String savedPassword = parts[0];
        if (!password.equals(savedPassword)) {
            throw new FailedLoginException("用户名和密码不匹配！");
        }
        authSucceeded = true;
        authUsername = username;
        roles = parts[1].split(",");
        return true;
    }

    public boolean commit() throws LoginException {
        if (authSucceeded) {
            this.subject.getPrincipals().add(new UserPrincipal(authUsername));
            for (String role : roles) {
            	this.subject.getPrincipals().add(new RolePrincipal(role));
            }
            subject.setReadOnly();
            authUsername = null;
            authSucceeded = false;
            roles = null;
            return true;
        }
        return false;
    }

    public boolean abort() throws LoginException {
        authUsername = null;
        if (authSucceeded) {
            authSucceeded = false;
            roles = null;
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
