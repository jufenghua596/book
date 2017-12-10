package com.java7book.chapter12;

import java.util.List;

public class GenericSignature <S extends Number> {
    public S obj;
    public void set(S obj) {
        this.obj = obj;
    }
    public S get(S obj) {
        return obj;
    }
    public List<? extends Number> create() {
        return null;
    }
}
