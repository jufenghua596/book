package com.java7book.chapter10.serialization;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class OrderTO implements Serializable {
    private String orderId;
    public OrderTO(Order order) {
        this.orderId = order.getId();
    }
    private Object readResolve() throws ObjectStreamException {
        return OrderGateway.getOrder(orderId);
    }
}
