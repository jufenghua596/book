package com.java7book.chapter13.access;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;

import com.java7book.chapter13.auth.UserPrincipal;

public class SubjectDoAs {
    
    public void doAs() {
        Subject subject = new Subject();
        UserPrincipal principal = new UserPrincipal("Alex");
        subject.getPrincipals().add(principal);
        subject.setReadOnly();
        String userHome = Subject.doAsPrivileged(subject, new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty("user.home");
           }
        }, null);  
        System.out.println(userHome);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SubjectDoAs sda = new SubjectDoAs();
        sda.doAs();
    }

}
