package com.java7book.chapter10.serialization;

public class OrderGateway {
    public static Order getOrder(String id) {
        User user = new User("alex", "alex@example.org");
        return new Order(id, user);
    }
}
