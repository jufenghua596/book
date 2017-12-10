package com.java7book.chapter10.serialization;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class User implements Serializable {
    
    //private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("name", String.class) };  
    
    private String name;
    private String email;
    private Address address;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
