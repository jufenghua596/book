package com.java7book.chapter10.serialization;

import java.io.IOException;

public class OrderTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Bob", "bob@example.org");
        Order order = new Order("1", user);
        String path = "order.bin";
        SerializationUtils.write(order, path);
        order = (Order) SerializationUtils.read(path);
        System.out.println(order.getId());
    }

}
