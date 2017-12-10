package com.java7book.chapter10.serialization;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Order implements Serializable {
    private User user;
    private String id;
    public Order(String id, User user) {
        this.id = id;
        this.user = user;
    }
    public String getId() {
        return this.id;
    }
    private Object writeReplace() throws ObjectStreamException {
        return new OrderTO(this);
    }  
}
