package com.java7book.chapter13.auth;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class MyApp {
    private LoginContext loginContext;
    public MyApp() throws LoginException {
        TextCallbackHandler callbackHandler = new TextCallbackHandler();
        loginContext = new LoginContext("MyApp", callbackHandler);
    }
    
    public Subject login() throws LoginException {
        loginContext.login();
        return loginContext.getSubject();
    }
    
    public void logout() throws LoginException {
        loginContext.logout();
    }
    
    public static void main(String[] args) {
        try {
            MyApp myApp = new MyApp();
            Subject subject = myApp.login();
            System.out.println(subject);
            myApp.logout();
            System.out.println(subject);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
