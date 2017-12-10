package com.java7book.chapter10;

public class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public User(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
